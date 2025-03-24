package dataModel;

import java.util.ArrayList;
import java.util.List;

public class ComplexTask extends Task {
    private List<Task> Tasks;

    public ComplexTask(int idTask, String statusTask) {
        super(idTask, statusTask);
        Tasks = new ArrayList<Task>();
    }

    public void addTask(Task task) {
        Tasks.add(task);
    }

    public void deleteTask(Task task) {
        Tasks.remove(task);
    }

    @Override
    public int estimateDuration() {
        int workDuration = 0;

        for(Task t : Tasks) {
            if(t instanceof ComplexTask) {
                workDuration += ((ComplexTask)t).estimateDuration();
            }else {
                workDuration+= ((SimpleTask)t).estimateDuration();
            }
        }

        return workDuration;
    }

    @Override
    public String toString() {
        return "ComplexTask: ID: " + getIdTask() + ", Status: " + getStatusTask() + "\n\n\n" + "Task duration: " + estimateDuration();
    }
}
