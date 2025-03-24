package GUI;


import BusinessLogic.TaskManagement;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;

public class MainPageView extends JFrame {
    private JPanel contentPanel = new JPanel();

    private JPanel centerPanel1 = new JPanel();
    private JPanel centerPanel2 = new JPanel();
    private JPanel centerPanel3 = new JPanel();


    private JButton goToManagement = new JButton("Go to Management");
    private JButton AddEmployeesAndTasks = new JButton("Add employees and tasks");
    private JButton ViewStatistics = new JButton("View statistics");



    public MainPageView() {
        this.setTitle("Management System main page");
        this.setSize(400, 300);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);

        //Aici am construit pagina principala, user-ul poate apasa pe unu dintre butoanele definite mai sus ca sa deschida o fereastra noua care va face ceva
        //Am combinat 2 Flow-uri: unul ca sa centrez butonul si celalalt ca sa le pun unul sub altul la o distanta setata (GLUE)

        contentPanel.setLayout(new BoxLayout(contentPanel, BoxLayout.Y_AXIS));
        centerPanel1.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel2.setLayout(new FlowLayout(FlowLayout.CENTER));
        centerPanel3.setLayout(new FlowLayout(FlowLayout.CENTER));

        centerPanel1.add(goToManagement);


        centerPanel2.add(AddEmployeesAndTasks);
        centerPanel3.add(ViewStatistics);

        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(centerPanel1);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(centerPanel2);
        contentPanel.add(Box.createVerticalGlue());
        contentPanel.add(centerPanel3);
        contentPanel.add(Box.createVerticalGlue());




        this.add(contentPanel);
        this.setVisible(true);
    }

    public void addListeners(ActionListener MPG ) {
        this.goToManagement.setActionCommand("goToManagement");
        this.goToManagement.addActionListener(MPG);

        this.AddEmployeesAndTasks.setActionCommand("AddEmployeesAndTasks");
        this.AddEmployeesAndTasks.addActionListener(MPG);

        this.ViewStatistics.setActionCommand("ViewStatistics");
        this.ViewStatistics.addActionListener(MPG);
    }

}
