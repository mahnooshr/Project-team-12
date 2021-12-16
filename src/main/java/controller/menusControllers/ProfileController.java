package controller.menusControllers;

import controller.utilityController.ImportExportController;
import controller.utilityController.RegexController;
import model.User;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProfileController extends MenuController {
    public ProfileController() {
        super("profile menu");
    }

    public String changePass(String oldPass, String newPass) {
        if (!getActiveUser().getPassword().equals(oldPass)) {
            return "wrong old password";
        } else if (oldPass.equals(newPass)) {
            return "please enter new password";
        } else if (!RegexController.isPasswordValid(newPass)) {
            return "Please Choose A strong Password (Containing at least 8 characters including 1 digit and 1 Capital Letter)";
        } else {
            getActiveUser().setPassword(newPass);
            ImportExportController.getInstance().refreshUsersToFileJson();
            return "password changed successfully";
        }
    }

    public String changeUsername(String newUsername) {
        Matcher matcher = Pattern.compile("([\\w\\d_]{4,})").matcher(newUsername);
        if (newUsername.length() <= 4) {
            return "Your new username must include at least 4 characters!";
        } else if (User.getUserByUsername(newUsername) != null) {
            return "username already taken!";
        } else if (!matcher.find()) {
            return "New username contains Special Characters! Please remove them and try again";
        } else if (getActiveUser().getUsername().equals(newUsername)) {
            return "you already have this username !";
        } else {
            getActiveUser().setUsername(newUsername);
            return "username successfully changed";
        }
    }
}
