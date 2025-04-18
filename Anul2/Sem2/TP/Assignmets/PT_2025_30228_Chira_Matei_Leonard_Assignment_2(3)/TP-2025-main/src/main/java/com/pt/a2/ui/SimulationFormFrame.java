package com.pt.a2.ui;

import com.pt.a2.DataModels.SimulationController;

import javax.swing.*;

public class SimulationFormFrame extends JFrame {
    private final SettingsFormPanel form;


    public SimulationFormFrame() {
        setTitle("Simulation settings form");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(BaseFrame.DEFAULT_WIDTH, BaseFrame.DEFAULT_HEIGHT);
        setLocationRelativeTo(null);
        setVisible(true);

        this.form = new SettingsFormPanel(e -> handleSubmit());

        add(form.getPanel());
    }

    private void handleSubmit() {
        try {
            setVisible(false);
            var formData = form.getSimulationData();
            var controllerThread = new Thread(new SimulationController(formData));
            controllerThread.start();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage(), "error", JOptionPane.ERROR_MESSAGE);
        }
    }

}
