package com.pt.a2.DataModels;

import com.pt.a2.Business.Client;
import com.pt.a2.Business.Queue;

import java.util.List;

public class ShortestQueueDispatcherStrategy implements QueueDispatcherStrategy {

    @Override
    public void dispatch(List<Queue> queues, Client client) {
        var minQueue = queues.getFirst();
        int min = minQueue.size();

        for (Queue q : queues) {
            if (q.size() < min) {
                min = q.size();
                minQueue = q;
            }
        }

        minQueue.add(client);
    }
}
