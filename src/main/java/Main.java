import controller.utilityController.ImportExportController;
import model.Priority;
import view.LoginMenuView;

public class Main {
        public static void main(String[] args) {
                ImportExportController.getInstance().refreshUsersFromFileJson();
                LoginMenuView loginMenuView = LoginMenuView.getInstance();
                loginMenuView.run();
        }
}
