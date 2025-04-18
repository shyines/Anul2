package com.pt.a2.Business;

import com.pt.a2.DataModels.Interval;

import java.util.ArrayList;
import java.util.List;

public class ClientFactory {
    private static int uid = 0;

    public static List<Client> create(int n, Interval aInterval, Interval sInterval) {
        List<Client> generatedClients = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int randomArrivalTime = aInterval.random();
            int randomServiceTime = sInterval.random();
            generatedClients.add(new Client(++uid, randomArrivalTime, randomServiceTime));
        }

        return generatedClients;
    }
}
