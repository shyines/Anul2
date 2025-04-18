package com.pt.a2.DataModels;

import com.pt.a2.Business.Client;
import com.pt.a2.Business.Queue;
import com.pt.a2.Business.SelectionPolicy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Scheduler {
    private final List<Queue> queues;
    private final ExecutorService executorService;
    private final Clock clock;
    private QueueDispatcherStrategy queueDispatcherStrategy;

    public Scheduler(int queueCount, Clock clock) {
        this.queues = new ArrayList<>();
        this.executorService = Executors.newFixedThreadPool(queueCount);
        this.queueDispatcherStrategy = QueueDispatcherFactory.get(SelectionPolicy.SHORTEST_QUEUE);
        this.clock = clock;

        for (int i = 0; i < queueCount; i++) {
            this.queues.add(new Queue(clock));
        }

        for (var q : queues) {
            executorService.execute(q);
        }
    }

    public void changeDispatchStrategy(SelectionPolicy selectionPolicy) {
        queueDispatcherStrategy = QueueDispatcherFactory.get(selectionPolicy);
    }

    public synchronized void dispatch(Client client) {
        queueDispatcherStrategy.dispatch(this.queues, client);
    }

    public boolean isFinished() {
        for (var q : queues) {
            if (!q.isEmpty())
                return false;
        }

        return true;
    }

    public void shutdown() {
        for (var q : queues) {
            q.stop();
        }
        clock.shutdown();
        executorService.shutdown();
    }

    public int getNumberOfEnqueuedClients() {
        int totalNumberOfClients = 0;

        for (var q : queues) {
            totalNumberOfClients += q.size();
        }

        return totalNumberOfClients;
    }

    @Override
    public String toString() {
        StringBuilder format = new StringBuilder();
        for (int i = 0; i < queues.size(); i++) {
            format.append(String.format("Queue %d:", i))
                    .append(queues.get(i))
                    .append("\n");
        }
        return format.toString();
    }
}
