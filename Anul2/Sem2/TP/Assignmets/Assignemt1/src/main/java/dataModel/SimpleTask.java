package dataModel;

public class SimpleTask extends Task {
    private int startHour;
    private int endHour;

    public SimpleTask(int idTask, String statusTask, int startHour, int endHour) {
        super(idTask, statusTask);
        this.startHour = startHour;
        this.endHour = endHour;
    }

    public int estimateDuration() {
        return endHour - startHour;
    }

    public void setEndHour(int endHour) {
        this.endHour = endHour;
    }

    public void setStartHour(int startHour) {
        this.startHour = startHour;
    }

    public int getEndHour() {
        return endHour;
    }

    public int getStartHour() {
        return startHour;
    }


    public String toString() {
        return "SimpleTask: ID: " + getIdTask() + ", Status: " + getStatusTask() + "\n\n\n\n" + "Work Duration: " + estimateDuration();
    }
}
