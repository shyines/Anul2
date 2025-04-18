package com.pt.a2.DataModels;

import com.pt.a2.Business.Client;
import com.pt.a2.Business.Queue;

import java.util.List;

public class ShortestTimeDispatcherStrategy implements QueueDispatcherStrategy {
    @Override
    public void dispatch(List<Queue> queues, Client client) {
        var minQueue = queues.getFirst();
        int minTime = minQueue.waitingTime();

        for (Queue q : queues) {
            if (q.waitingTime() < minTime) {
                minQueue = q;
                minTime = minQueue.waitingTime();
            }
        }

        minQueue.add(client);
    }
}
