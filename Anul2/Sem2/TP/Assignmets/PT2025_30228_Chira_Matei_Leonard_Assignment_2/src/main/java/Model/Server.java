package Model;

import java.util.concurrent.BlockingDeque;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.atomic.AtomicInteger;

public class Server implements Runnable{

    private BlockingDeque<Task> tasks;
    private AtomicInteger waitingPeriod;

    public Server() {
        tasks = new LinkedBlockingDeque<>();
        waitingPeriod = new AtomicInteger(0);
    }

    public void addTask(Task task) {
        if(!tasks.contains(task)) {
            tasks.add(task);
        }
    }

    @Override
    public void run() {

    }

    public Task[] getTasks() {
        return tasks.toArray(new Task[0]);
    }
}
