package com.pt.a2.domain.dispatcher;

import com.pt.a2.model.Client;
import com.pt.a2.model.Queue;

import java.util.Comparator;
import java.util.List;

public class ShortestQueueDispatcherStrategy implements QueueDispatcherStrategy {

    @Override
    public void dispatch(List<Queue> queues, Client client) {
        queues.stream()
                .min(Comparator.comparingInt(Queue::size))
                .ifPresent(queue -> queue.add(client));
    }
}
