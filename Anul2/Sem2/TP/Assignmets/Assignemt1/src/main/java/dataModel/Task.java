package dataModel;

import java.io.Serializable;

public abstract class Task implements Serializable {
    private int idTask;
    private String statusTask;

    Task(int idTask, String statusTask) {
        this.idTask = idTask;
        this.statusTask = statusTask;
    }

    public int getIdTask() {
        return idTask;
    }

    public String getStatusTask() {
        return statusTask;
    }

    public void setIdTask(int idTask) {
        this.idTask = idTask;
    }

    public void setStatusTask(String statusTask) {
        this.statusTask = statusTask;
    }

    int estimateDuration() {/// to implement
        return 0;
    }
}
