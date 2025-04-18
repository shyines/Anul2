package com.pt.a2.ui;

import com.pt.a2.Business.SelectionPolicy;
import com.pt.a2.DataAccess.SimulationData;
import com.pt.a2.DataModels.Interval;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionListener;
import java.util.Objects;

public class SettingsFormPanel {
    private static final int DEFAULT_WIDTH = 700, DEFAULT_HEIGHT = 700;
    private static final int X_OFFSET = 150, Y_OFFSET = 50, COMPONENT_WIDTH = 250, COMPONENT_HEIGHT = 60, ROW_SPACING = 80;  // Increased width and height
    private final JPanel panel;
    private final LabeledTextField queueCount;
    private final LabeledTextField clientCount;
    private final LabeledTextField minArrivalTime;
    private final LabeledTextField maxArrivalTime;
    private final LabeledTextField minServiceTime;
    private final LabeledTextField maxServiceTime;
    private final JComboBox<String> strategy;
    private final LabeledTextField maxTime;

    public SettingsFormPanel(ActionListener onSubmit) {
        this.panel = new JPanel(null);
        panel.setPreferredSize(new Dimension(DEFAULT_WIDTH, DEFAULT_HEIGHT));

        // Initialize the components
        queueCount = new LabeledTextField("Queue Count");
        queueCount.setBounds(X_OFFSET, Y_OFFSET, COMPONENT_WIDTH, COMPONENT_HEIGHT);

        clientCount = new LabeledTextField("Client Count");
        clientCount.setBounds(X_OFFSET + COMPONENT_WIDTH + 20, Y_OFFSET, COMPONENT_WIDTH, COMPONENT_HEIGHT);

        minArrivalTime = new LabeledTextField("Min Arrival Time");
        minArrivalTime.setBounds(X_OFFSET, Y_OFFSET + ROW_SPACING, COMPONENT_WIDTH, COMPONENT_HEIGHT);

        maxArrivalTime = new LabeledTextField("Max Arrival Time");
        maxArrivalTime.setBounds(X_OFFSET + COMPONENT_WIDTH + 20, Y_OFFSET + ROW_SPACING, COMPONENT_WIDTH, COMPONENT_HEIGHT);

        minServiceTime = new LabeledTextField("Min Service Time");
        minServiceTime.setBounds(X_OFFSET, Y_OFFSET + 2 * ROW_SPACING, COMPONENT_WIDTH, COMPONENT_HEIGHT);

        maxServiceTime = new LabeledTextField("Max Service Time");
        maxServiceTime.setBounds(X_OFFSET + COMPONENT_WIDTH + 20, Y_OFFSET + 2 * ROW_SPACING, COMPONENT_WIDTH, COMPONENT_HEIGHT);


        maxTime = new LabeledTextField("Max time");
        maxTime.setBounds(X_OFFSET, Y_OFFSET + 3 * ROW_SPACING,  COMPONENT_WIDTH * 2 + 20, COMPONENT_HEIGHT);  // Full width

        strategy = new JComboBox<>(new String[]{"SHORTEST_QUEUE", "SHORTEST_TIME"});
        strategy.setBounds(X_OFFSET, Y_OFFSET + 4 * ROW_SPACING,  COMPONENT_WIDTH * 2 + 20, COMPONENT_HEIGHT);

        // Button to start the simulation
        JButton startSimulationButton = new JButton("Begin Simulation");
        startSimulationButton.setBounds(X_OFFSET , Y_OFFSET + 5 * ROW_SPACING, COMPONENT_WIDTH * 2 + 20, COMPONENT_HEIGHT);
        startSimulationButton.addActionListener(onSubmit);

        // Add components to the panel
        panel.add(queueCount);
        panel.add(clientCount);
        panel.add(minArrivalTime);
        panel.add(maxArrivalTime);
        panel.add(minServiceTime);
        panel.add(maxServiceTime);
        panel.add(strategy);
        panel.add(maxTime);
        panel.add(startSimulationButton);
    }

    public SimulationData getSimulationData() throws Exception {
        try {
            var aInterval = Interval.with(
                    Integer.parseInt(minArrivalTime.getText()), Integer.parseInt(maxArrivalTime.getText())
            );

            var sInterval = Interval.with(
                    Integer.parseInt(minServiceTime.getText()), Integer.parseInt(maxServiceTime.getText())
            );

            return new SimulationData(
                    Integer.parseInt(maxTime.getText()),
                    sInterval,
                    aInterval,
                    Integer.parseInt(queueCount.getText()),
                    Integer.parseInt(clientCount.getText()),
                    SelectionPolicy.fromString((String) Objects.requireNonNull(strategy.getSelectedItem()))
            );
        } catch (NumberFormatException e) {
            throw new Exception("Please enter valid number " + e.getMessage());
        } catch (IllegalArgumentException e) {
            throw new Exception(e);
        }
    }

    public JPanel getPanel() {
        return panel;
    }
}
