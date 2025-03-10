import java.util.List;

public class ComplexTask extends Task {
    private List<Task> Tasks;

    ComplexTask(int idTask, String statusTask) {
        super(idTask, statusTask);
    }

    void addTask(Task task) {
        Tasks.add(task);
    }

    void deleteTask(Task task) {
        Tasks.remove(task);
    }

    @Override
    int estimateDuration() { /// to implement
        return 0;
    }
}
