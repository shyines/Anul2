package GUI.TaskManagement;

import BusinessLogic.TaskManagement;
import dataModel.Employee;
import dataModel.Task;

import javax.swing.*;
import javax.swing.event.ListSelectionListener;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;

public class TaskManagementView extends JFrame {

    //Declaring all the components that I need

    //TaskManagementController contoller = new TaskManagementController(this);

    JList<Task> assignedTasksList = new JList<>();
    DefaultListModel<Task> assignedTasksModel = new DefaultListModel<>();
    JLabel employeeNameLabel = new JLabel("Employee Name");
    JTextField employeeNameTextField = new JTextField(10);
    JList<Employee> employeeList = new JList<>();
    DefaultListModel<Employee> employeeListModel = new DefaultListModel<>();
    JLabel taskDescriptionLabel = new JLabel("Task Description");
    JCheckBox taskCompleted = new JCheckBox("Completed");

    JCheckBox taskUncompleted = new JCheckBox("Uncompleted");
    JButton applyButton = new JButton("Apply");
    JButton showTasksButton = new JButton("Tasks");
    JTextField idTextField = new JTextField(10);
    JButton addEmployeeButton = new JButton("Register Employee");
    JButton addComplexTaskButton = new JButton("Add complex task");
    JButton addSimpleTaskButton = new JButton("Add simple task");
    JList<Task> unassignedTasksList = new JList<>();
    DefaultListModel<Task> unassignedTasksModel = new DefaultListModel<>();
    JButton assignTasksToEmployee = new JButton("Assign Tasks to Employee");
    JTextArea taskDescriptiontextArea = new JTextArea();
    //Creating the layout of the Window
    public TaskManagementView() {

        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setSize(1280, 720);
        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new GridLayout(2, 1));

        JPanel TopPanel = new JPanel();
        TopPanel.setLayout(new GridLayout(1, 2));
            JPanel TopLeftPanel = new JPanel();
            TopLeftPanel.setLayout(new GridLayout(1, 2));
            JPanel EmployeePanel = new JPanel();
            EmployeePanel.setLayout(new BorderLayout(5, 5));
            JPanel EmployeeNamePanel = new JPanel(); //Component
            EmployeeNamePanel.setLayout(new FlowLayout());
            EmployeeNamePanel.add(employeeNameLabel);//Component
            EmployeeNamePanel.add(employeeNameTextField);//Component
            EmployeePanel.add(EmployeeNamePanel, BorderLayout.NORTH);

            //Adding the EmployeeList
            employeeList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            employeeList.setModel(employeeListModel);
            employeeList.setVisibleRowCount(-1);
            employeeList.setLayoutOrientation(JList.VERTICAL);
            employeeList.setVisible(true);
            EmployeePanel.add(employeeList, BorderLayout.CENTER);
            TopLeftPanel.add(EmployeePanel);

            //Adding the Task List
            JPanel AssignedTasksPanel = new JPanel();
            AssignedTasksPanel.setLayout(new BorderLayout(5, 5));
            assignedTasksList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
            assignedTasksList.setModel(assignedTasksModel);
            AssignedTasksPanel.add(assignedTasksList, BorderLayout.CENTER);
            AssignedTasksPanel.add(showTasksButton, BorderLayout.NORTH);

            TopLeftPanel.add(AssignedTasksPanel);
            TopPanel.add(TopLeftPanel);

        //Task description area
        JPanel TopRightPanel = new JPanel();
        TopRightPanel.setLayout(new BorderLayout(5, 5));
        TopRightPanel.add(taskDescriptionLabel , BorderLayout.NORTH);
        JPanel CompletedUncompletedTasksPanel = new JPanel();
        CompletedUncompletedTasksPanel.setLayout(new BoxLayout(CompletedUncompletedTasksPanel, BoxLayout.Y_AXIS));
        CompletedUncompletedTasksPanel.add(taskCompleted);
        taskCompleted.setSelected(false);
        CompletedUncompletedTasksPanel.add(taskUncompleted);
        taskUncompleted.setSelected(false);
        JPanel ApplyButton = new JPanel();
        ApplyButton.setLayout(new BorderLayout());
        ApplyButton.add(applyButton);
        CompletedUncompletedTasksPanel.add(ApplyButton);
        TopRightPanel.add(CompletedUncompletedTasksPanel, BorderLayout.SOUTH);

        taskDescriptiontextArea.setEditable(false);
        TopRightPanel.add(taskDescriptiontextArea, BorderLayout.CENTER);
        TopPanel.add(TopRightPanel);


        JPanel bottomPanel = new JPanel();
        bottomPanel.setLayout(new BorderLayout(5, 5));
            JPanel bottomPanelWest = new JPanel();
            bottomPanelWest.setLayout(new BoxLayout(bottomPanelWest, BoxLayout.Y_AXIS));

            JPanel fillInEmployee = new JPanel();
            fillInEmployee.setLayout(new FlowLayout());
                JPanel namePanel = new JPanel();
                namePanel.setLayout(new BoxLayout(namePanel, BoxLayout.Y_AXIS));
                namePanel.add(employeeNameLabel, LEFT_ALIGNMENT);
                namePanel.add(employeeNameTextField);
                fillInEmployee.add(namePanel);

                JPanel idPanel = new JPanel();
                idPanel.setLayout(new BoxLayout(idPanel, BoxLayout.Y_AXIS));
                idPanel.add(new JLabel("ID"), LEFT_ALIGNMENT);
                idPanel.add(idTextField);
                fillInEmployee.add(idPanel);

                bottomPanelWest.add(fillInEmployee, LEFT_ALIGNMENT);
                bottomPanelWest.add(addEmployeeButton, LEFT_ALIGNMENT);
                bottomPanel.add(bottomPanelWest, BorderLayout.WEST);

        JPanel bottomPanelEast = new JPanel();
        bottomPanelEast.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanelEast.add(addComplexTaskButton);
        bottomPanelEast.add(addSimpleTaskButton);
        bottomPanel.add(bottomPanelEast, BorderLayout.EAST);

        JPanel bottomPanelNorth = new JPanel();
        bottomPanelNorth.setLayout(new FlowLayout(FlowLayout.CENTER));
        bottomPanelNorth.add(new JLabel("Register employees and add simple or complex tasks"));
        bottomPanel.add(bottomPanelNorth, BorderLayout.NORTH);
        JPanel bottomPanelCenter = new JPanel();
        bottomPanelCenter.setLayout(new BorderLayout());
        bottomPanelCenter.add(unassignedTasksList);
        unassignedTasksList.setModel(unassignedTasksModel);
        unassignedTasksList.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        unassignedTasksList.setVisibleRowCount(-1);
        unassignedTasksList.setLayoutOrientation(JList.VERTICAL);
        bottomPanelCenter.add(assignTasksToEmployee, BorderLayout.SOUTH);
        bottomPanel.add(bottomPanelCenter, BorderLayout.CENTER);

        mainPanel.add(TopPanel);
        mainPanel.add(bottomPanel);


        this.getContentPane().add(mainPanel);
        this.setVisible(true);

    }

    //Getters for the Controller
    public JLabel getEmployeeNameLabel() {
        return employeeNameLabel;
    }

    public JButton getApplyButton() {
        return applyButton;
    }

    public JCheckBox getTaskCompleted() {
        return taskCompleted;
    }

    public JCheckBox getTaskUncompleted() {
        return taskUncompleted;
    }

    public JLabel getTaskDescriptionLabel() {
        return taskDescriptionLabel;
    }

    public JList<Task> getAssignedTasksList() {
        return assignedTasksList;
    }

    public DefaultListModel<Task> getAssignedTasksModel () {
        return assignedTasksModel;
    }

    public JList<Employee> getEmployeeList() {
        return employeeList;
    }

    public JTextField getEmployeeNameTextField() {
        return employeeNameTextField;
    }

    public void setEmployeeList(Map<Employee, List<Task>> map) {
        employeeListModel.clear();

        for(Map.Entry<Employee, List<Task>> entry : map.entrySet()) {
            employeeListModel.addElement(entry.getKey());
        }
    }

    public JTextField getIdTextField() {
        return idTextField;
    }

    public DefaultListModel<Employee> getEmployeeListModel() {
        return employeeListModel;
    }

    public JTextArea getTaskDescriptiontextArea() {
        return taskDescriptiontextArea;
    }

    public JList<Task> getUnassignedTasksList() {
        return unassignedTasksList;
    }

    public DefaultListModel<Task> getUnassignedTasksModel() {
        return unassignedTasksModel;
    }

    public void addActionListeners(ActionListener actionListener, ListSelectionListener listSelectionListener) {
        applyButton.addActionListener(actionListener);
        applyButton.setActionCommand("applyButton");

        addEmployeeButton.addActionListener(actionListener);
        addEmployeeButton.setActionCommand("addEmployeeButton");

        addComplexTaskButton.addActionListener(actionListener);
        addComplexTaskButton.setActionCommand("addComplexTaskButton");

        addSimpleTaskButton.addActionListener(actionListener);
        addSimpleTaskButton.setActionCommand("addSimpleTaskButton");

        assignTasksToEmployee.addActionListener(actionListener);
        assignTasksToEmployee.setActionCommand("assignTasksToEmployee");

        showTasksButton.addActionListener(actionListener);
        showTasksButton.setActionCommand("showTasksButton");

        assignedTasksList.addListSelectionListener(listSelectionListener);
    }
}
