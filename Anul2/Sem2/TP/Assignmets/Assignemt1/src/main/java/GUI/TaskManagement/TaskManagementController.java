package GUI.TaskManagement;

import BusinessLogic.TaskManagement;
import BusinessLogic.Utility;
import Serialization.DataManager;
import dataModel.ComplexTask;
import dataModel.Employee;
import dataModel.Task;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import static javax.swing.UIManager.get;

public class TaskManagementController {
        private final TaskManagementView view;
        private final TaskManagementModel model;
        private AddSimpleTaskView simpleTaskView;
        private AddComplexTaskView complexTaskView;
        private DataManager dataManager = new DataManager();

        public TaskManagementController(TaskManagementView taskManagementView, TaskManagementModel model) {
            this.view = taskManagementView;
            this.model = model;
            TaskManagement taskManagement = this.model.getDataBase();
            taskManagement = dataManager.loadData();
            this.model.setDataBase(taskManagement);
            this.model.getUtil().setTaskManagement(taskManagement);
            view.setEmployeeList(model.getEmployeesList());
            model.showUnassignedTasksList(view.getUnassignedTasksModel());
            this.view.addActionListeners(new TaskManagementListener(), new TaskManagementListListener());
        }

        class TaskManagementListener implements ActionListener {
            @Override
            public void actionPerformed(ActionEvent e) {
                String command = e.getActionCommand();

                switch (command) {
                    case "showTasksButton": {
                        model.showTasksforAnEmployee(
                                view.employeeListModel.get(view.employeeList.getSelectedIndex()),
                                view.getAssignedTasksModel()
                        );
                        break;
                    }

                    case "addEmployeeButton": {
                        String id = view.getIdTextField().getText();
                        String name = view.getEmployeeNameTextField().getText();

                        try {
                            model.registerEmployee(name, id);
                        } catch (Exception ex) {
                            System.out.println(ex.getMessage());
                            view.getIdTextField().setText("");
                            view.getEmployeeNameTextField().setText("");
                        } catch (DetailsException ex) {
                            System.out.println(ex.getMessage());
                        }
                        dataManager.saveData(model.getDataBase());
                        view.getEmployeeListModel().clear();
                        view.setEmployeeList(model.getEmployeesList());
                        break;
                    }

                    case "addSimpleTaskButton": {
                        simpleTaskView = new AddSimpleTaskView();
                        simpleTaskView.setVisible(true);
                        simpleTaskView.addActionListener(e1 -> {
                            String idTask = simpleTaskView.getIdTask().getText();
                            String startHour = simpleTaskView.getStartHour().getText();
                            String endHour = simpleTaskView.getEndHour().getText();

                            String foreignCommand = e1.getActionCommand();

                            if(foreignCommand.equals("AddTask")) {
                                model.addSimpleTask(Integer.parseInt(idTask), "Uncompleted", Integer.parseInt(startHour), Integer.parseInt(endHour));
                                System.out.println("Successfully added task");
                                dataManager.saveData(model.getDataBase());
                            }

                            model.showUnassignedTasksList(view.unassignedTasksModel);
                        });
                        break;
                    }

                    case "assignTasksToEmployee" : {
                       Employee emp = view.getEmployeeListModel().get(view.employeeList.getSelectedIndex());
                       Task task = view.unassignedTasksModel.get(view.unassignedTasksList.getSelectedIndex());

                       model.getDataBase().assignTaskToEmployee(emp, task);
                       view.unassignedTasksModel.removeElement(task);
                       model.getDataBase().removeUnassignedTask(task);
                       dataManager.saveData(model.getDataBase());

                       break;
                    }

                    case "applyButton": {
                        Employee emp = view.getEmployeeListModel().get(view.employeeList.getSelectedIndex());
                        Task task = view.assignedTasksModel.get(view.assignedTasksList.getSelectedIndex());

                        boolean selectedCompleted = view.getTaskCompleted().isSelected();
                        boolean selectedUncompleted = view.getTaskUncompleted().isSelected();

                        model.modifyTask(task, selectedCompleted, selectedUncompleted);
                        dataManager.saveData(model.getDataBase());
                        view.getAssignedTasksModel().clear();

                        model.showTasksforAnEmployee(emp, view.getAssignedTasksModel());
                        break;
                    }

                    case "addComplexTaskButton" : {
                        complexTaskView = new AddComplexTaskView();
                        complexTaskView.setVisible(true);
                        complexTaskView.setTaskList(/*view.getUnassignedTasksList(),*/ view.getUnassignedTasksModel()/*, model.getDataBase().getUnassignedTasks()*/);

                        complexTaskView.addActionListeners(e1 -> {
                            // Retrieve the task ID
                            String idTask = complexTaskView.getTaskId().getText().trim();

                            // Retrieve the selected tasks from the JList
                            List<Task> selectedTasks = complexTaskView.getTaskList().getSelectedValuesList();

                            // Validate input
                            if (idTask.isEmpty()) {
                                JOptionPane.showMessageDialog(complexTaskView, "Please enter a task ID.", "Input Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            if (selectedTasks.isEmpty()) {
                                JOptionPane.showMessageDialog(complexTaskView, "Please select at least one task.", "Selection Error", JOptionPane.ERROR_MESSAGE);
                                return;
                            }

                            int taskId = Integer.parseInt(idTask);
                            ComplexTask ct = new ComplexTask(taskId, "Uncompleted");

                            for(Task task : selectedTasks) {
                                ct.addTask(task);
                            }

                            model.getDataBase().getUnassignedTasks().add(ct);
                            model.showUnassignedTasksList(view.unassignedTasksModel);
                            dataManager.saveData(model.getDataBase());
                        });
                    }
                }
            }
        }

        class TaskManagementListListener implements ListSelectionListener {

            @Override
            public void valueChanged(ListSelectionEvent e) {
                if (e.getValueIsAdjusting()) {
                    return;
                }

                // Get the selected index from the JList
                int selectedIndex = view.assignedTasksList.getSelectedIndex();

                // Check if the selected index is valid
                if (selectedIndex == -1) {
                    // No item is selected, clear the text area and radio buttons
                    view.getTaskDescriptiontextArea().setText("");
                    view.getTaskCompleted().setSelected(false);
                    view.getTaskUncompleted().setSelected(false);
                    return;
                }

                // Check if the list model is empty
                if (view.getAssignedTasksModel().isEmpty()) {
                    // List is empty, clear the text area and radio buttons
                    view.getTaskDescriptiontextArea().setText("");
                    view.getTaskCompleted().setSelected(false);
                    view.getTaskUncompleted().setSelected(false);
                    return;
                }

                // Get the selected task from the list model
                Task tsk = view.getAssignedTasksModel().get(selectedIndex);

                // Update the task description and status
                Employee emp = view.getEmployeeListModel().get(view.getEmployeeList().getSelectedIndex());
                view.getTaskDescriptiontextArea().setText(tsk.toString() + "\n Employee work duration -completed tasks-: "
                        + model.getDataBase().calculateEmployeeWorkDuration(emp) + "\n" + model.getDataBase().completedUncompletedTasks(emp)
                        + "\n Further descripition: Employees with above forty hours of work: \n" +
                        model.getUtil().AboveFortyHours());
                if (tsk.getStatusTask().equals("Completed")) {
                    view.getTaskCompleted().setSelected(true);
                    view.getTaskUncompleted().setSelected(false);
                } else {
                    view.getTaskCompleted().setSelected(false);
                    view.getTaskUncompleted().setSelected(true);
                }
            }
        }
}
