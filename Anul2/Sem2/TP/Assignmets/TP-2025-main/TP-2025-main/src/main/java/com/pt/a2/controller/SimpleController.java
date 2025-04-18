package com.pt.a2.controller;

import com.pt.a2.model.SimulationData;

public class SimpleController extends AbstractController{

    public SimpleController(SimulationData simulationData) {
        this.simulationData = simulationData;
        initialize(simulationData);
    }

    @Override
    public void run() {

        while (true) {
            totalWaitingTime += checkAndPutInQueue(clock.getCurrentTime());
            checkAndUpdatePeakHour();
            logger.log(this);


            try {
                boolean continueSimulation = clock.tick();
                if (!continueSimulation || (scheduler.isFinished() && clients.isEmpty())) {
                    break;
                }

            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }

        scheduler.shutdown();
        var metrics = getSimulationStats();
        logger.log(metrics);
        logger.close();
    }

}
