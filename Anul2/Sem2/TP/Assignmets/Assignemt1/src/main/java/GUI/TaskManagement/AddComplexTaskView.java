package GUI.TaskManagement;

import dataModel.Task;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AddComplexTaskView extends javax.swing.JFrame {

    JPanel mainPanel;
    JList <Task> taskList;
    DefaultListModel <Task> taskListModel;
    JButton addTask;
    JLabel complexTask;
    JTextField taskId;

    public AddComplexTaskView() {
        this.setTitle("Add Complex Task");
        this.setSize(500, 500);


        mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout());

        complexTask = new JLabel("Id Task", SwingConstants.CENTER);
        taskId = new JTextField(10);
        JPanel labelAndText = new JPanel();
        labelAndText.setLayout(new BoxLayout(labelAndText, BoxLayout.Y_AXIS));
        labelAndText.add(complexTask);
        labelAndText.add(taskId);
        mainPanel.add(labelAndText, BorderLayout.NORTH);

        taskList = new JList<>();
        taskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
        taskListModel = new DefaultListModel <>();
        taskList.setModel(taskListModel);
        taskList.setLayoutOrientation(JList.VERTICAL);
        taskList.setFixedCellWidth(250);

        mainPanel.add(taskList, BorderLayout.CENTER);

        addTask = new JButton("Add Task");
        mainPanel.add(addTask, BorderLayout.SOUTH);

        this.add(mainPanel, BorderLayout.CENTER);
        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public void addActionListeners(ActionListener actionListener) {
        addTask.addActionListener(actionListener);
    }

    public void setTaskList(DefaultListModel <Task> taskListModel) {
        this.taskList = taskList;
        this.taskListModel = taskListModel;

        this.taskList.setModel(taskListModel);
        this.taskList.setSelectionMode(ListSelectionModel.MULTIPLE_INTERVAL_SELECTION);
    }

    public JTextField getTaskId() {
        return taskId;
    }

    public JList<Task> getTaskList() {
        return taskList;
    }

    public DefaultListModel<Task> getTaskListModel() {
        return taskListModel;
    }
}
