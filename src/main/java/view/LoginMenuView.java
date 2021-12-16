package view;

import controller.menusControllers.LoginMenuController;
import controller.utilityController.RegexController;
import controller.utilityController.UtilController;

import java.util.HashMap;

public class LoginMenuView extends MenuView {
    private static LoginMenuView loginMenuView = null;
    LoginMenuController loginMenuController = new LoginMenuController();

    {
        nextMenu = MainMenuView.getInstance();
    }

    public LoginMenuView() {
        super("login menu");
    }

    public static LoginMenuView getInstance() {
        if (loginMenuView == null)
            loginMenuView = new LoginMenuView();
        return loginMenuView;
    }

    @Override
    public void run() {
        while (true) {
            UtilController.printString(this.getName() + "\n");
            String command = UtilController.getInput();
            if (command.startsWith("user create")) {
                checkRegisterInput(command);
            } else if (command.startsWith("user login")) {
                checkLoginInput(command);
            } else if (command.startsWith("exit")) {
                exit = true;
            }
            else{
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

    private void checkLoginInput(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.loginRegex(command, info)) {
            UtilController.printString("invalid format");
        } else {
            String username = info.get("username");
            String password = info.get("password");
            String response = loginMenuController.loginUser(username, password);
            UtilController.printString(response);
            if (response.equals("login successfully"))
                enter = true;
        }
    }

    private void checkRegisterInput(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.registerRegex(command, info)) {
            UtilController.printString("invalid format");
        } else {
            String username = info.get("username");
            String password1 = info.get("password1");
            String password2 = info.get("password2");
            String email = info.get("email");
            UtilController.printString(loginMenuController.register(username, password1, password2, email));
        }
    }
}



