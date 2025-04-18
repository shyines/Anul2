package com.pt.a2.DataModels;

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
                doneCondition.await(); // await for all queues to reach barrier
            }

            if (currentTime >= maxTime) {
                tickCondition.signalAll(); // signal to rerun
                return false;
            }

            currentTime++;
            waitingThreads = 0;
            tickCondition.signalAll(); // signal to run
            return true;
        } finally {
            lock.unlock();
        }
    }

    public void await() throws InterruptedException {
        lock.lock();

        try {
            waitingThreads++; // another thread has reached the barrier
            if (waitingThreads == totalWorkers) {
                doneCondition.signal(); // all queues reached barrier
            }
            tickCondition.await(); // lower barrier
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
