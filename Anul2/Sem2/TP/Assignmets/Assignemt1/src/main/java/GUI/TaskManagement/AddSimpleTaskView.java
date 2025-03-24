package GUI.TaskManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class AddSimpleTaskView extends javax.swing.JFrame {
         JPanel mainPanel;
         JButton addButton;
         JTextField idTask;
         JTextField startHour;
         JTextField endHour;

    AddSimpleTaskView () {
        this.setSize(200, 200);

        mainPanel = new JPanel();
        mainPanel.setLayout(new FlowLayout());
        addButton = new JButton("Add");
        idTask = new JTextField(5);
        startHour = new JTextField(5);
        endHour = new JTextField(5);

        mainPanel.add(idTask);
        mainPanel.add(startHour);
        mainPanel.add(endHour);
        mainPanel.add(addButton);

        this.add(mainPanel, BorderLayout.CENTER);

        this.setContentPane(mainPanel);
        this.setVisible(true);
    }

    public void addActionListener(ActionListener actionListener) {
        addButton.addActionListener(actionListener);
        addButton.setActionCommand("AddTask");
    }

    public JTextField getIdTask() {
        return idTask;
    }

    public JTextField getStartHour() {
        return startHour;
    }

    public JTextField getEndHour() {
        return endHour;
    }

    public JButton getAddButton() {
        return addButton;
    }

}
