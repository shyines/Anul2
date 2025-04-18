package com.pt.a2.DataModels;

import com.pt.a2.Business.SelectionPolicy;

import java.util.HashMap;
import java.util.Map;

public class QueueDispatcherFactory {
    private static final Map<SelectionPolicy, QueueDispatcherStrategy> context = new HashMap<>() {{
        put(SelectionPolicy.SHORTEST_QUEUE, new ShortestQueueDispatcherStrategy());
        put(SelectionPolicy.SHORTEST_TIME, new ShortestTimeDispatcherStrategy());
    }};

    public static QueueDispatcherStrategy get(SelectionPolicy selectionPolicy) {
        return context.get(selectionPolicy);
    }
}
