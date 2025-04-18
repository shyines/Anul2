package com.pt.a2.model;

import com.pt.a2.domain.dispatcher.SelectionPolicy;
import com.pt.a2.utils.Interval;

public record SimulationData(
        int time,
        Interval serviceTimeInterval,
        Interval arrivalTimeInterval,
        int qCount,
        int clientCount,
        SelectionPolicy selectionPolicy
) {

    public static SimulationData create() {
        int tMaxSimulation = 60;
        var aInterval = Interval.with(2, 30);
        var sInterval = Interval.with(2, 4);
        int q = 2;
        int n = 4;
        var policy = SelectionPolicy.SHORTEST_QUEUE;

        return new SimulationData(
                tMaxSimulation, aInterval, sInterval, q, n, policy
        );
    }

    public static SimulationData create(String[] args) {
        int tMaxSimulation = 60;
        var aInterval = Interval.with(2, 30);
        var sInterval = Interval.with(2, 4);
        int q = 2;
        int n = 4;
        var policy = SelectionPolicy.SHORTEST_QUEUE;

        int i = 0;
        while (i < args.length) {
            switch (args[i]) {
                case "--time", "-t" -> {
                    if (i + 1 < args.length) {
                        i += 1;
                        tMaxSimulation = Integer.parseInt(args[i]);
                    }
                }
                case "--clients", "-c" -> {
                    if (i + 1 < args.length) {
                        i += 1;
                        n = Integer.parseInt(args[i]);
                    }
                }
                case "--queues", "-q" -> {
                    if (i + 1 < args.length) {
                        i += 1;
                        q = Integer.parseInt(args[i]);
                    }
                }
                case "--arrival-interval" -> {
                    if (i + 2 < args.length) {
                        aInterval = Interval.with(Integer.parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
                        i += 2;
                    }
                }
                case "--service-interval" -> {
                    if (i + 2 < args.length) {
                        sInterval = Interval.with(Integer.parseInt(args[i + 1]), Integer.parseInt(args[i + 2]));
                        i += 2;
                    }
                }
                case "--policy", "-p" -> {
                    if (i + 1 < args.length) {
                        policy = SelectionPolicy.fromString(args[i + 1]);
                        i += 1;
                    }
                }
            }
            i++;
        }

        return new SimulationData(
                tMaxSimulation, aInterval, sInterval, q, n, policy
        );
    }
}
