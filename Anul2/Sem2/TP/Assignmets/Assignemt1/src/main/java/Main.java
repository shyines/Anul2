import BusinessLogic.TaskManagement;
import BusinessLogic.Utility;
import GUI.MainPageController;
import GUI.MainPageView;
import GUI.TaskManagement.TaskManagementView;

public class Main {

    public static void main(String[] args) {
        TaskManagement dataBase = new TaskManagement();
        Utility utility = new Utility(dataBase);
        MainPageView mainPage = new MainPageView();
        MainPageController MPG = new MainPageController(mainPage, dataBase, utility);
    }
}