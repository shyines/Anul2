package com.pt.a2.DataModels;

import com.pt.a2.Business.Client;
import com.pt.a2.Business.Queue;

import java.util.List;

public interface QueueDispatcherStrategy {
    void dispatch(List<Queue> queues, Client client);
}
