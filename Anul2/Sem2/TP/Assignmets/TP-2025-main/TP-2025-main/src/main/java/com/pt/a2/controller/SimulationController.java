package com.pt.a2.controller;

import com.pt.a2.model.SimulationData;
import com.pt.a2.ui.RefreshableFrame;
import com.pt.a2.ui.SimulationFrame;

public class SimulationController extends AbstractController {
    private final RefreshableFrame frame;

    public SimulationController(SimulationData simulationData) {
        this.simulationData = simulationData;
        initialize(simulationData);
        this.frame = new SimulationFrame(this.toString());
    }


    @Override
    public void run() {

        while (true) {
            totalWaitingTime += checkAndPutInQueue(clock.getCurrentTime());
            checkAndUpdatePeakHour();
            logger.log(this);


            try {
                this.frame.refresh(this.toString());
                boolean continueSimulation = clock.tick();
                if (!continueSimulation || (scheduler.isFinished() && clients.isEmpty())) {
                    break;
                }

                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        scheduler.shutdown();
        var metrics = getSimulationStats();
        logger.log(metrics);
        logger.close();
        this.frame.refresh(metrics.toString());
    }
}
