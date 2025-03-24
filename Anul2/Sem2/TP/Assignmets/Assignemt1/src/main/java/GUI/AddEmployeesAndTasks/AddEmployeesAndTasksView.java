package GUI.AddEmployeesAndTasks;

import javax.swing.*;

public class AddEmployeesAndTasksView extends JFrame {
    private JPanel contentPane;

    public AddEmployeesAndTasksView(){
        contentPane = new JPanel();
        this.setContentPane(contentPane);
        this.setTitle("Task Management View");
        this.setDefaultCloseOperation(DISPOSE_ON_CLOSE);
        this.setBounds(100, 100, 450, 300);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
}
