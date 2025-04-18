package com.pt.a2.Business;

public class Client {
    private final int id;
    private final int arrivalTime;
    private int serviceTime;

    public Client(int id, int aTime, int sTime) {
        this.id = id;
        this.arrivalTime = aTime;
        this.serviceTime = sTime;
    }

    public synchronized void decrementServiceTime() {
        serviceTime--;
    }

    public boolean isFullyServed() {
        return serviceTime == 0;
    }

    public int getServiceTime() {
        return serviceTime;
    }

    public boolean canEnterInQueue(int time) {
        return arrivalTime == time;
    }

    @Override
    public String toString() {
        var format = "(%d, %d, %d)";
        return String.format(format, id, arrivalTime, serviceTime);
    }
}
