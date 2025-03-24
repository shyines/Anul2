package GUI;

import BusinessLogic.TaskManagement;
import BusinessLogic.Utility;
import GUI.AddEmployeesAndTasks.AddEmployeesAndTasksView;
import GUI.TaskManagement.TaskManagementController;
import GUI.TaskManagement.TaskManagementModel;
import GUI.TaskManagement.TaskManagementView;
import GUI.ViewStatistics.ViewStatisticsView;
//import jdk.tools.jmod.Main;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainPageController {
    private MainPageView MPV;
    static private TaskManagement dataBase;
    static private Utility util;


    public MainPageController(MainPageView mpv, TaskManagement dataBase, Utility util) {
        this.MPV = mpv;
        this.MPV.addListeners(new MainPageListener());
        MainPageController.dataBase = dataBase;
        MainPageController.util = util;
    }

    public TaskManagement getDataBase() {
        return dataBase;
    }

    /// un switch pe commanda - fiecare case imi deschide o fereastra


    static class MainPageListener implements ActionListener {
        MainPageController mainPageController;
        @Override
        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();

            switch (command) {
                case "goToManagement":
                    TaskManagementView tm = new TaskManagementView();
                    TaskManagementModel tMM = new TaskManagementModel(MainPageController.dataBase, MainPageController.util);
                    TaskManagementController tmc = new TaskManagementController(tm, tMM);
                    tm.setVisible(true);
                    break;
                case "AddEmployeesAndTasks":
                    AddEmployeesAndTasksView atv = new AddEmployeesAndTasksView();
                    atv.setVisible(true);
                    break;

                case "ViewStatistics":
                    ViewStatisticsView vst = new ViewStatisticsView();
                    vst.setVisible(true);
                    break;

                default:
                    break;
            }

        }
    }
}
