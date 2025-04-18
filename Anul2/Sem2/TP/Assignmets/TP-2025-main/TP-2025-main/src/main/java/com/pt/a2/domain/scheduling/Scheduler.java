package com.pt.a2.domain.scheduling;

import com.pt.a2.domain.dispatcher.QueueDispatcherFactory;
import com.pt.a2.domain.dispatcher.QueueDispatcherStrategy;
import com.pt.a2.domain.dispatcher.SelectionPolicy;
import com.pt.a2.model.Client;
import com.pt.a2.model.Queue;

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

        queues.forEach(executorService::execute);
        /*
        for(Queue queue: queues) {
            executorService.execute(queue); //New Thread()
        }
        */
    }

    public void changeDispatchStrategy(SelectionPolicy selectionPolicy) {
        queueDispatcherStrategy = QueueDispatcherFactory.get(selectionPolicy);
    }

    public synchronized void dispatch(Client client) {
        queueDispatcherStrategy.dispatch(this.queues, client);
    }

    public boolean isFinished() {
        return queues.stream().allMatch(Queue::isEmpty);
    }
    /*
    for each
        if !queue.empty
            return false
        return true
     */

    public void shutdown() {
        queues.forEach(Queue::stop);
        clock.shutdown();
        executorService.shutdown();
    }

    public int getNumberOfEnqueuedClients() {
        return queues.stream()
                .mapToInt(Queue::size)
                .sum();
    }
    /*
        sum = 0;
        for each queue //stream library
            sum += queue.size
     */
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
