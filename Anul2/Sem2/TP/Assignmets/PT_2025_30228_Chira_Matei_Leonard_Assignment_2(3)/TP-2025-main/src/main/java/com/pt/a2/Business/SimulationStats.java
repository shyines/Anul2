package com.pt.a2.Business;

public class SimulationStats {

    private double averageWaitingTime;
    private double averageServiceTime;
    private int peakHour;

    public SimulationStats(double averageWaitingTime, double averageServiceTime, int peakHour) {
        this.averageWaitingTime = averageWaitingTime;
        this.averageServiceTime = averageServiceTime;
        this.peakHour = peakHour;
    }

    @Override
    public String toString() {
        var format = "Average waiting time: %.2f\nAverageServiceTime: %.2f\nPeak hour: %d\n";
        return String.format(format, averageWaitingTime, averageServiceTime, peakHour);
    }

    public double getAverageWaitingTime() {
        return averageWaitingTime;
    }

    public double getAverageServiceTime() {
        return averageServiceTime;
    }

    public int getPeakHour() {
        return peakHour;
    }

    public void setAverageWaitingTime(double averageWaitingTime) {
        this.averageWaitingTime = averageWaitingTime;
    }

    public void setAverageServiceTime(double averageServiceTime) {
        this.averageServiceTime = averageServiceTime;
    }

    public void setPeakHour(int peakHour) {
        this.peakHour = peakHour;
    }
}
