package com.pt.a2;

import com.pt.a2.controller.SimpleController;
import com.pt.a2.controller.SimulationController;
import com.pt.a2.model.SimulationData;
import com.pt.a2.ui.RefreshableFrame;
import com.pt.a2.ui.SimulationFormFrame;


public class Main{

    public static void main(String[] args) throws InterruptedException {
        commandLineRunner(args);
    }

    private static void commandLineRunner(String[] args) throws InterruptedException {
        if (args.length > 0) {
            var data = SimulationData.create(args);
            var controller = new SimpleController(data);
            var thread = new Thread(controller);
            thread.start();
            thread.join();
        } else {
            SimulationFormFrame frame = new SimulationFormFrame();
            frame.setVisible(true);
        }


    }
}