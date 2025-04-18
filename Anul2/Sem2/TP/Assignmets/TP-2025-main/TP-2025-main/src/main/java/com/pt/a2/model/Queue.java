package com.pt.a2.model;

import com.pt.a2.domain.scheduling.Clock;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Queue implements Runnable {
    private final BlockingDeque<Client> clients;
    private final AtomicInteger waitingTime;
    private volatile boolean running = true;
    private Clock clock;

    public Queue() {
        clients = new LinkedBlockingDeque<>();
        waitingTime = new AtomicInteger(0);
    }

    public Queue(Clock clock) {
        clients = new LinkedBlockingDeque<>();
        waitingTime = new AtomicInteger(0);
        this.clock = clock;
    }

    public synchronized void add(Client client) {
        clients.add(client);
        waitingTime.addAndGet(client.getServiceTime());
    }

    public boolean isEmpty() {
        return clients.isEmpty();
    }

    public int size() {
        return clients.size();
    }

    public int waitingTime() {
        return waitingTime.get();
    }

    public void stop() {
        running = false;
    }

    @Override
    public String toString() {
        return clients.isEmpty() ? "empty" : clients.toString();
    }

    @Override
    public void run() {
        while (running) {
            try {
                clock.await();//se asteapta ca toate thread urile sa fie pregatite

                Client client = clients.peek();
                if (client != null) {
                    assert !client.isFullyServed() : "should not have finished clients in queue";
                    client.decrementServiceTime();
                    waitingTime.decrementAndGet();

                    if (client.isFullyServed()) {
                        var isRemoved = clients.remove(client);
                        assert isRemoved : "isRemoved must be true at this point";
                    }
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
                break;
            }
        }
    }
}
