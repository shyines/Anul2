package BusinessLogic;

import dataModel.Employee;
import dataModel.Task;

import java.io.Serializable;
import java.rmi.server.UID;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class Utility implements Serializable {
    private TaskManagement taskManagement;
    private Map<Integer, Employee> aboveFortyHours;


    public Utility (TaskManagement taskManagement) {
        aboveFortyHours = new TreeMap<>();
        this.taskManagement = taskManagement;
    }

    public String AboveFortyHours() {
        Map<Employee, List<Task>> Employees = taskManagement.getTaskManager();
        StringBuilder ans = new StringBuilder();
        for(Employee employee : Employees.keySet()) {
            Integer workDuration = taskManagement.calculateEmployeeWorkDuration(employee);
            if(workDuration > 40) {
                aboveFortyHours.put(workDuration, employee);
            }
        }

        for(Employee employee : aboveFortyHours.values()) {
            ans.append(employee.getName()).append("\n");
        }

        return ans.toString();
    }

    public Map<Integer, Employee> getAboveFortyHours() {
        return aboveFortyHours;
    }

    public void setTaskManagement(TaskManagement taskManagement) {
        this.taskManagement = taskManagement;
    }
}
