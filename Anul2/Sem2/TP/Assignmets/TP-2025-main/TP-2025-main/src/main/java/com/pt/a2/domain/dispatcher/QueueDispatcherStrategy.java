package com.pt.a2.domain.dispatcher;

import com.pt.a2.model.Client;
import com.pt.a2.model.Queue;

import java.util.List;

public interface QueueDispatcherStrategy {
    void dispatch(List<Queue> queues, Client client);
}
