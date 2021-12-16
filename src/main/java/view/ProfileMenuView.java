package view;

import controller.menusControllers.MenuController;
import controller.menusControllers.ProfileController;
import controller.utilityController.UtilController;

import java.util.HashMap;

public class ProfileMenuView extends MenuView {
    private static ProfileMenuView profileMenuView = null;
    ProfileController profileController = new ProfileController();

    public ProfileMenuView() {
        super("profile menu");
    }

    public static ProfileMenuView getInstance() {
        if (profileMenuView == null) {
            profileMenuView = new ProfileMenuView();
        }
        return profileMenuView;
    }

    @Override
    public void run() {
        while (true) {
            UtilController.printString(this.getName() + "\n");
            String command = UtilController.getInput();
            if (command.startsWith("Profile --change --oldPassword")) {
                checkChangePassRegex(command);
            } else if (command.startsWith("Profile --change --username")) {
                checkChangeUsernameRegex(command);
            } else if (command.equals("Profile --showTeams")) {
                ShowTeams();
            } else if (command.startsWith("Profile --showTeam")) {
                checkShowTeamRegex(command);
            } else if (command.equals("Profile --show --myProfile")) {
                UtilController.printString(showProfile());
            } else if (command.equals("Profile --show notifications")) {
                showNotification();
            } else if (command.equals("Profile --show logs")) {
                showLogs();
            } else if (command.equals("back")) {
                exit = true;
            } else {
                UtilController.printString("invalid command");
            }
            if (exit) {
                exit = false;
                return;
            }
        }
    }

    private void showLogs() {

    }

    private void showNotification() {
    }

    private String showProfile() {
        return MenuController.getInstance().getActiveUser().toString();
    }

    private void checkShowTeamRegex(String command) {
    }

    private void ShowTeams() {
    }

    private void checkChangeUsernameRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.changeUsernameRegex(info, command)) {
            UtilController.printString("invalid command");
        } else {
            String newUsername = info.get("username");
            UtilController.printString(profileController.changeUsername(newUsername));
        }
    }

    private void checkChangePassRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.changePassRegex(info, command)) {
            UtilController.printString("invalid command");
        } else {
            String oldPass = info.get("oldPass");
            String newPass = info.get("newPass");
            UtilController.printString(profileController.changePass(oldPass, newPass));
        }
    }
}
