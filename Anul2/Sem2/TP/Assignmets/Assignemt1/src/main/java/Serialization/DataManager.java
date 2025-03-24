package Serialization;

import BusinessLogic.TaskManagement;
import BusinessLogic.TaskManagement;


import java.io.*;

    public class DataManager {
        private static final String FILE_PATH = "appData.dat";

        public void saveData(TaskManagement appData) {
            try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_PATH))) {
                System.out.println("Saving: Employees and assigned tasks = " + appData.getTaskManager().size() + ", Unsigned tasks = " + appData.getUnassignedTasks().size());
                oos.writeObject(appData);
                oos.flush();
                oos.close();
            } catch (IOException e) {
                System.err.println("Error saving data: " + e.getMessage());
            }
        }

        public TaskManagement loadData() {
            try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_PATH))) {
                TaskManagement data = (TaskManagement) ois.readObject();
                System.out.println("Loaded: Employees and assigned tasks = " + data.getTaskManager().size() + ", Unsigned tasks = " + data.getUnassignedTasks().size());
                return data;
            } catch (IOException | ClassNotFoundException e) {
                System.err.println("Error loading data, creating new AppData: " + e.getMessage());
                return new TaskManagement();
            }
        }
    }
