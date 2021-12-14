package view;

import controller.menusControllers.MainMenuController;
import controller.utilityController.RegexController;
import controller.utilityController.UtilController;

import java.util.HashMap;

public class MainMenuView extends MenuView {

    private static MainMenuView mainMenuView = null;
    MainMenuController mainMenuController = new MainMenuController();

    private MainMenuView() {
        super("main menu");
    }

    public static MainMenuView getInstance() {
        if (mainMenuView == null) {
            mainMenuView = new MainMenuView();
        }
        return mainMenuView;
    }


    @Override
    public void run() {
        while (true) {
            showMenus();
            String command = UtilController.getInput();
            if (command.startsWith("menu enter")) {
                checkEnterMenuRegex(command);
            } else if (command.equals("user logout")) {
                checkLogoutCommand();
            } else if (command.equals("back")) {
                UtilController.printString("navigation back is not possible in this menu. please logout out if you want to exit");
            } else {
                UtilController.printString("invalid command");
            }
            if (enter) {
                enter = false;
                nextMenu.run();
            }
            if (exit) {
                exit = false;
                return;
            }
        }
    }

    private void showMenus() {
        UtilController.printString(this.getName() + "\n" +
                "1. Profile Menu\n" +
                "2. Teams Menu\n" +
                "3. Tasks Page\n" +
                "4. Calender Menu\n" +
                "5. Notification Bar\n\n");
    }

    private void checkLogoutCommand() {
        UtilController.printString("logout successfully");
        mainMenuController.setActiveUser(null);
        exit = true;
    }

    private void checkEnterMenuRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!RegexController.enterMenuRegex(command, info)) {
            UtilController.printString("invalid command");
        } else {
            String response = mainMenuController.menuEnter(info.get("menuName"));
            if (response.equals("menu enter successfully")) {
                nextMenu = MainMenuController.getAllMenus().get(info.get("menuName"));
                enter = true;
            }
            UtilController.printString(response);
        }
    }
}
