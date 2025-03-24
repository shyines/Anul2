package GUI.TaskManagement;

import BusinessLogic.TaskManagement;
import BusinessLogic.Utility;
import dataModel.Employee;
import dataModel.SimpleTask;
import dataModel.Task;

import javax.swing.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class TaskManagementModel {
    private TaskManagement dataBase;
    private Utility util;

    public TaskManagementModel(TaskManagement dataBase, Utility util) {
        this.dataBase = dataBase;
        this.util = util;
    }

    public Map<Employee, List<Task>> getEmployeesList() {
        return dataBase.getTaskManager();
    }

    public TaskManagement getDataBase() {
        return dataBase;
    }

    public void showTasksforAnEmployee(Employee employee, DefaultListModel<Task> employeeTasksListModel) {
        List<Task> tasks = dataBase.getTaskManager().get(employee);
        if(employeeTasksListModel != null) {
            employeeTasksListModel.clear();
        }

        for(Task task : tasks) {
            employeeTasksListModel.addElement(task);
        }
    }

    public void registerEmployee(String name, String id) throws Exception, DetailsException {
        Set<Employee> employeeSet = dataBase.getTaskManager().keySet();

        for(Employee employee : employeeSet) {
            if(employee.getName().equals(name) && employee.getIdEmployee() == Integer.parseInt(id)) {
                throw new Exception("An employee with this name already exists");
            }else if(name.isEmpty() && id.isEmpty()) {
                throw new DetailsException("No details provided");
            }
        }

        dataBase.addEmployee(new Employee(name, Integer.parseInt(id)));
    }

    public void addSimpleTask(int idTask, String taskStatus, int startHour, int endHour) {
        dataBase.addUnassignedTask(new SimpleTask (idTask, taskStatus, startHour, endHour));

        System.out.println("Added task " + idTask + " to task manager");
    }
    /* aparent nu imi trebuie, nu inteleg
    public String getTaskDescription(Employee emp, Task tsk) {
        List<Task> tasks = dataBase.getTaskManager().get(emp);

        for(Task t : tasks) {
            if(tsk.equals(t)) {
                return tsk.toString();
            }
        }
    }
     */
    public void showUnassignedTasksList(DefaultListModel<Task> unassignedTasksListModel) {
        unassignedTasksListModel.clear();
        for(Task task : dataBase.getUnassignedTasks()) {
            unassignedTasksListModel.addElement(task);
        }

    }

    public void modifyTask(Task task, boolean selectedCompleted, boolean selectedUncompleted) {
        if(selectedCompleted) {
            task.setStatusTask("Completed");
        }

        if(selectedUncompleted) {
            task.setStatusTask("Uncompleted");
        }
    }

    public void setDataBase(TaskManagement dataBase) {
        this.dataBase = dataBase;
    }

    public Utility getUtil() {
        return this.util;
    }
}
