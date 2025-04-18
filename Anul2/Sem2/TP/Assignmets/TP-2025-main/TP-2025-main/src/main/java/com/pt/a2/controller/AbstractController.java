package com.pt.a2.controller;

import com.pt.a2.domain.scheduling.Clock;
import com.pt.a2.domain.scheduling.Scheduler;
import com.pt.a2.model.Client;
import com.pt.a2.model.ClientFactory;
import com.pt.a2.model.SimulationData;
import com.pt.a2.model.SimulationStats;
import com.pt.a2.ui.RefreshableFrame;
import com.pt.a2.utils.LogFileFactory;
import com.pt.a2.utils.Logger;

import java.util.Iterator;
import java.util.List;

public abstract class AbstractController implements Runnable {
    protected SimulationData simulationData;
    protected Scheduler scheduler;
    protected List<Client> clients;
    protected Logger logger;
    protected Clock clock;
    protected double avgServiceTime;
    protected double totalWaitingTime;
    protected double maxEnqueuedClients = 0;
    protected int peakHour = 0;


    protected void initialize(SimulationData simulationData) {
        this.clock = new Clock(simulationData.time(), simulationData.qCount());
        this.scheduler = new Scheduler(simulationData.qCount(), clock);
        this.scheduler.changeDispatchStrategy(simulationData.selectionPolicy());

        this.clients = ClientFactory.create(
                simulationData.clientCount(), simulationData.arrivalTimeInterval(), simulationData.serviceTimeInterval()
        );

        this.avgServiceTime = clients.stream()
                .mapToDouble(Client::getServiceTime)
                .average()
                .orElse(0);

        this.logger = new Logger(LogFileFactory.getPathName(simulationData));
    }

    public SimulationStats getSimulationStats() {
        var avgWaitingTime = totalWaitingTime / simulationData.clientCount();
        return new SimulationStats(avgWaitingTime, this.avgServiceTime, this.peakHour);
    }

    protected int checkAndPutInQueue(int time) {
        int accumulatedWaitingTime = 0;
        Iterator<Client> it = clients.iterator();

        while (it.hasNext()) {
            var client = it.next();
            if (client.canEnterInQueue(time)) {
                accumulatedWaitingTime += time;
                scheduler.dispatch(client);
                it.remove();
            }
        }

        return accumulatedWaitingTime;
    }

    protected void checkAndUpdatePeakHour() {
        var enqueuedClientCount = scheduler.getNumberOfEnqueuedClients();

        if (enqueuedClientCount > maxEnqueuedClients) {
            maxEnqueuedClients = enqueuedClientCount;
            peakHour = clock.getCurrentTime();
        }
    }

    @Override
    public String toString() {
        var format = "%s\nWaiting clients: %s\n%s";
        return String.format(format, clock, clients, scheduler);
    }

    public abstract void run();
}
