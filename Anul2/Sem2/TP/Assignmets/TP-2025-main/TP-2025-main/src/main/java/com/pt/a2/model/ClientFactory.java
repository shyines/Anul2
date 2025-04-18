package com.pt.a2.model;

import com.pt.a2.utils.Interval;

import java.util.ArrayList;
import java.util.List;

public class ClientFactory {
    private static int uid = 0;

    public static Client create(int aTime, int sTime) {
        return new Client(++uid, aTime, sTime);
    }

    public static List<Client> create(int n, Interval aInterval, Interval sInterval) {
        List<Client> generatedClients = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int randomArrivalTime = aInterval.random();
            int randomServiceTime = sInterval.random();
            generatedClients.add(create(randomArrivalTime, randomServiceTime));
        }

        return generatedClients;
    }
}
