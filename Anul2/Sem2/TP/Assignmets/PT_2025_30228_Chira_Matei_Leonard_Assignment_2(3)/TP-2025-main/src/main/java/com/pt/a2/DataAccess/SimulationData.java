package com.pt.a2.DataAccess;

import com.pt.a2.Business.SelectionPolicy;
import com.pt.a2.DataModels.Interval;

public class SimulationData {
    private int time;
    private Interval serviceTimeInterval;
    private Interval arrivalTimeInterval;
    private int qCount;
    private int clientCount;
    private SelectionPolicy selectionPolicy;

    public SimulationData(int time, Interval serviceTimeInterval, Interval arrivalTimeInterval, int qCount, int clientCount, SelectionPolicy selectionPolicy) {
        this.time = time;
        this.serviceTimeInterval = serviceTimeInterval;
        this.arrivalTimeInterval = arrivalTimeInterval;
        this.qCount = qCount;
        this.clientCount = clientCount;
        this.selectionPolicy = selectionPolicy;
    }

    public int getTime() {
        return time;
    }

    public Interval getServiceTimeInterval() {
        return serviceTimeInterval;
    }

    public Interval getArrivalTimeInterval() {
        return arrivalTimeInterval;
    }

    public int getqCount() {
        return qCount;
    }

    public int getClientCount() {
        return clientCount;
    }

    public SelectionPolicy getSelectionPolicy() {
        return selectionPolicy;
    }

    public void setTime(int time) {
        this.time = time;
    }
}
