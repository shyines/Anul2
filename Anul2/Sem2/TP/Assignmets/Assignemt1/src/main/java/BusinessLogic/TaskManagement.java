package BusinessLogic;

import Serialization.DataManager;
import dataModel.ComplexTask;
import dataModel.Employee;
import dataModel.SimpleTask;
import dataModel.Task;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TaskManagement implements Serializable {
    private Map<Employee, List<Task>> TaskManager;
    private ArrayList<Task> unassignedTasks;

    public TaskManagement() {
        TaskManager = new HashMap<Employee, List<Task>>();
        unassignedTasks = new ArrayList<>();
    }

    public void addEmployee(Employee emp) {
        if(!TaskManager.containsKey(emp)) {
            TaskManager.put(emp, new ArrayList<Task>());
        }
    }

    public void assignTaskToEmployee(Employee employee, Task task) {
        List<Task> tasks = TaskManager.get(employee);
        tasks.add(task);
    }

    public void modifyTaskStatus(Employee employee, Task task, String status) {
        List<Task> tasks = TaskManager.get(employee);
        for(Task t : tasks) {
            if(t.getIdTask() == task.getIdTask()) {
                task.setStatusTask(status);
                break;
            }
        }
    }

    public int calculateEmployeeWorkDuration (Employee employee) {
        int workDuration = 0;
        List<Task> tasks = TaskManager.get(employee);
        for(Task t : tasks) {
            if(t.getStatusTask().equals("Completed") ) {
                if(t instanceof SimpleTask)
                    workDuration += ((SimpleTask) t).estimateDuration();
                else if(t instanceof ComplexTask) {
                    workDuration += ((ComplexTask) t).estimateDuration();
                }
            }
        }

        return workDuration;
    }

    public Map<Employee, List<Task>> getTaskManager() {
        return TaskManager;
    }

    public ArrayList<Task> getUnassignedTasks() {
        return unassignedTasks;
    }

    public void addUnassignedTask(Task task) {
        unassignedTasks.add(task);
    }

    public void removeUnassignedTask(Task task) {
        unassignedTasks.remove(task);
    }

    public String completedUncompletedTasks(Employee emp) {
        List<Task> tasks = TaskManager.get(emp);

        int completed = 0;
        int uncompleted = 0;

        for(Task t : tasks) {
            if(t.getStatusTask().equals("Completed")) {
                completed++;
            }else if(t.getStatusTask().equals("Uncompleted")) {
                uncompleted++;
            }
        }

        return "Uncompleted tasks: " + uncompleted + "\n" + " Completed tasks: " + completed;
    }
}
