package GUI;


import javax.swing.*;
import java.awt.*;

public class View extends JFrame {

    JTextField numberOfClientsTextArea = new JTextField(3);
    JLabel numberOfClientsLabel = new JLabel("Number of clients:");

    JLabel numberOfQueuesLabel = new JLabel("Number of queues:");
    JTextField numberOfQueuesTextArea = new JTextField(3);

    JLabel simulationIntervalLabel = new JLabel("Simulation interval:");
    JTextField simulationIntervalStartTextArea = new JTextField(3);
    JTextField simulationIntervalEndTextArea = new JTextField(3);

    JLabel arrivalTimeLabel = new JLabel("Arrival time:");
    JTextField maximumArrivalTimeText = new JTextField(3);
    JTextField minimumArrivalTimeText = new JTextField(3);

    JLabel serviceTimeLabel = new JLabel("Service time:");
    JTextField minimumServiceTimeTextArea = new JTextField(3);
    JTextField maximumServiceTimeText = new JTextField(3);


    JTextArea logTextArea;

    public View() {
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setSize(1280, 720);

        JPanel mainPanel = new JPanel();
        mainPanel.setLayout(new BorderLayout(5, 5));

        logTextArea = new JTextArea();
        logTextArea = new JTextArea(10, 40); // Rows and columns
        JScrollPane scrollPane = new JScrollPane(logTextArea);

        JPanel container = new JPanel(new BorderLayout());
        container.add(scrollPane, BorderLayout.CENTER); // Or CENTER with preferred size
        container.setBorder(BorderFactory.createEmptyBorder(100,100,100,100)); // Add padding

        mainPanel.add(container, BorderLayout.CENTER);

        JPanel northPanel = new JPanel();
        northPanel.setLayout(new BoxLayout(northPanel, BoxLayout.Y_AXIS));

        JPanel numberOfClientsPanel = new JPanel();
        numberOfClientsPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        numberOfClientsPanel.add(numberOfClientsLabel);
        numberOfClientsPanel.add(numberOfClientsTextArea);
        northPanel.add(numberOfClientsPanel);

        JPanel numberOfQueuesPanel = new JPanel();
        numberOfQueuesPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        numberOfQueuesPanel.add(numberOfQueuesLabel);
        numberOfQueuesPanel.add(numberOfQueuesTextArea);
        northPanel.add(numberOfQueuesPanel);

        JPanel simulationIntervalPanel = new JPanel();
        simulationIntervalPanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        simulationIntervalPanel.add(simulationIntervalLabel);
        simulationIntervalPanel.add(simulationIntervalStartTextArea);
        simulationIntervalPanel.add(simulationIntervalEndTextArea);
        northPanel.add(simulationIntervalPanel);

        JPanel arrivalTimePanel = new JPanel();
        arrivalTimePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        arrivalTimePanel.add(arrivalTimeLabel);
        arrivalTimePanel.add(minimumArrivalTimeText);
        arrivalTimePanel.add(maximumArrivalTimeText);
        northPanel.add(arrivalTimePanel);

        JPanel serviceTimePanel = new JPanel();
        serviceTimePanel.setLayout(new FlowLayout(FlowLayout.CENTER));
        serviceTimePanel.add(serviceTimeLabel);
        serviceTimePanel.add(maximumServiceTimeText);
        serviceTimePanel.add(minimumServiceTimeTextArea);
        northPanel.add(serviceTimePanel);

        northPanel.setBorder(BorderFactory.createEmptyBorder(10, 0, 0, 0));
        mainPanel.add(northPanel, BorderLayout.NORTH);

        this.getContentPane().add(mainPanel);
        this.setVisible(true);
    }

}
