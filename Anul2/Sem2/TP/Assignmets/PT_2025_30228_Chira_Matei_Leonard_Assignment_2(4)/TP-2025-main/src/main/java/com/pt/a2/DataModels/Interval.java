package com.pt.a2.DataModels;

public class Interval {
    private final int start;
    private final int end;

    private Interval(int start, int end) {
        if (start > end) {
            throw new IllegalArgumentException(String.format("start value must be lte end. Given: start=%d and end=%d", start, end));
        }
        this.start = start;
        this.end = end;
    }

    public static Interval with(int start, int end) {
        return new Interval(start, end);
    }

    public int size() {
        return end - start + 1;
    }

    public int random() {
        return (int) (Math.random() * (end - start) + start);
    }

    @Override
    public String toString() {
        var format = "[%d, %d]";
        return String.format(format, start, end);
    }
}
