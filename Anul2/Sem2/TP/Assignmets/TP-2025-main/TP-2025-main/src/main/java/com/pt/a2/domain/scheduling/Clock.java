package com.pt.a2.domain.scheduling;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

public class Clock {
    private final int maxTime;
    private final ReentrantLock lock = new ReentrantLock();
    private final Condition tickCondition = lock.newCondition();
    private final Condition doneCondition = lock.newCondition();
    private final int totalWorkers;
    private int currentTime = 0;
    private int waitingThreads = 0;

    public Clock(int maxTime, int totalWorkers) {
        this.maxTime = maxTime;
        this.totalWorkers = totalWorkers;
    }

    public boolean tick() throws InterruptedException {
        lock.lock();

        try {
            while (waitingThreads < totalWorkers) {
                doneCondition.await();
            }

            if (currentTime >= maxTime) {
                tickCondition.signalAll();
                return false;
            }

            currentTime++;
            waitingThreads = 0;
            tickCondition.signalAll();
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void await() throws InterruptedException {
        lock.lock();

        try {
            waitingThreads++;
            if (waitingThreads == totalWorkers) {
                doneCondition.signal();
            }
            tickCondition.await();
        } finally {
            lock.unlock();
        }
    }

    public void shutdown() {
        lock.lock();
        try {
            tickCondition.signalAll();
        } finally {
            lock.unlock();
        }
    }

    public int getCurrentTime() {
        return currentTime;
    }

    @Override
    public String toString() {
        return "Clock: " + currentTime;
    }
}
