package com.pt.a2.ui;

import javax.swing.*;
import java.awt.*;

public class SimulationFrame extends JFrame implements RefreshableFrame {

    private final JTextArea simulationDataTextArea;  // TextArea to display simulation data

    public SimulationFrame(String text) {
        setTitle("Simulation config");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(BaseFrame.DEFAULT_WIDTH, BaseFrame.DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);

        // Create a text area to display the simulation data
        simulationDataTextArea = new JTextArea(text);
        simulationDataTextArea.setEditable(false);
        simulationDataTextArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));

        // Add the text area to a scroll pane for better UI
        JScrollPane scrollPane = new JScrollPane(simulationDataTextArea);

        // Add the scroll pane to the center of the frame
        add(scrollPane, BorderLayout.CENTER);

        // Set a reasonable size for the frame
        setSize(800, 600);
        setLocationRelativeTo(null);  // Center on screen

        // Make sure the frame is ready to be displayed
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setVisible(true);

        // Initial text
        simulationDataTextArea.setText("Simulation initializing...");
    }

    // Standard refresh method
    public void refresh(Object simulationState) {
        simulationDataTextArea.setText(simulationState.toString());
        simulationDataTextArea.setCaretPosition(0);  // Scroll to top
        repaint();
    }
}