import controller.utilityController.ImportExportController;
import view.LoginMenuView;

public class Main {

    static {
        ImportExportController.getInstance().refreshUsersFromFileJson();
        ImportExportController.getInstance().refreshTasksFromFileJson();
    }

    public static void main(String[] args) {
        LoginMenuView loginMenuView = LoginMenuView.getInstance();
        loginMenuView.run();
    }
}
