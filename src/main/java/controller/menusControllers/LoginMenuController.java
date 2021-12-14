package controller.menusControllers;

import controller.utilityController.ImportExportController;
import model.User;

public class LoginMenuController extends MenuController {
    public LoginMenuController() {
        super("login menu");
    }

    public String register(String username, String password1, String password2, String email) {
        if (!User.isUsernameValid(username))
            return "username with name " + username + " already exists";
        else if (!password1.equals(password2))
            return "passwords are not the same";
        else if (!User.isPasswordValid(password1))
            return "username or password is not strong";
        else if (!User.isEmailValid(email))
            return "email is not valid";
        else if (!User.emailDoesNotExist(email)) {
            return "email already exists";
        } else {
            new User(username, password1, email);
            return "registered successfully";
        }
    }

    public String loginUser(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password))
            return "username or password didn't match";
        else {
            MenuController.getInstance().setActiveUser(user);
            return "login successfully";
        }
    }

    public String removeUser(String username, String password) {
        User user = User.getUserByUsername(username);
        if (user == null || !user.getPassword().equals(password))
            return "username or password invalid";
        else {
            User.removeByUserName(username);
            ImportExportController.getInstance().refreshUsersToFileJson();
            return "user deleted successfully";
        }
    }


}