package com.pt.a2.model;

public record SimulationStats(
        double averageWaitingTime,
        double averageServiceTime,
        int peakHour
) {

    @Override
    public String toString() {
        var format = "Average waiting time: %.2f\nAverageServiceTime: %.2f\nPeak hour: %d\n";
        return String.format(format, averageWaitingTime, averageServiceTime, peakHour);
    }
}
