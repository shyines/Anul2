package com.pt.a2.DataModels;

import com.pt.a2.Business.Client;
import com.pt.a2.Business.ClientFactory;
import com.pt.a2.DataAccess.SimulationData;
import com.pt.a2.Business.SimulationStats;
import com.pt.a2.Business.Logger;

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
        this.clock = new Clock(simulationData.getTime(), simulationData.getqCount());
        this.scheduler = new Scheduler(simulationData.getqCount(), clock);
        this.scheduler.changeDispatchStrategy(simulationData.getSelectionPolicy());

        this.clients = ClientFactory.create(
                simulationData.getClientCount(), simulationData.getArrivalTimeInterval(), simulationData.getServiceTimeInterval()
        );

        double totalServiceTime = 0;
        for (Client client : clients) {
            totalServiceTime += client.getServiceTime();
        }

        this.avgServiceTime = totalServiceTime / clients.size();
        this.logger = new Logger(LogFileFactory.getPathName(simulationData));
    }

    public SimulationStats getSimulationStats() {
        var avgWaitingTime = totalWaitingTime / simulationData.getClientCount();
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
