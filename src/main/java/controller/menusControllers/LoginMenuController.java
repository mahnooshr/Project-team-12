package controller.menuController;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import controller.responses.LoginMenuResponses;
import model.User;

public class LoginController extends MenuController {
    public LoginController() {
        super("Login Menu");
    }
public LoginMenuResponses welcom()
{
    return LoginMenuResponses.WELCOM;
}
    public LoginMenuResponses registerUser(String userName, String passWord , String passWord2,String Email) {
        databaseController.refreshUsersFromFileJson();
        if (User.getUserByUserName(userName) != null)
            return LoginMenuResponses.USER_USERNAME_ALREADY_EXISTS;
        else if (!isPasssame(passWord,passWord2))
            return LoginMenuResponses.PASS_NOT_SAME;
        else if (User.getUserByEmail(Email) != null)
            return LoginMenuResponses.USER_EMAIL_ALREADY_EXISTS;
        else if (!isEmailValid(Email))
            return LoginMenuResponses.EMAIL_IS_INVALID;
        else {
            User.getAllUsers().add(new User(userName,passWord,Email, User.UserType.MEMBER));
            databaseController.refreshUsersToFileJson();
            return LoginMenuResponses.USER_CREATE_SUCCESSFUL;
        }
    }
public boolean isPasssame(String password1,String password2)
{
    if(password1.equals(password2))
        return true;
    else
        return false;
}
public boolean isEmailValid(String Email)
{
    if(Email.matches("[A-Za-z0-9.]+@(yahoo.com|gmail.com)"))
    return true;
    else
    return false;
}
    public LoginMenuResponses loginUser(String username, String password) {
        databaseController.refreshUsersFromFileJson();
        if (User.getUserByUserName(username) == null) {
            return LoginMenuResponses.IS_NOT_USER;
            }
        else if(!User.getUserByUserName(username).getPassWord().equals(password))

    {
        return LoginMenuResponses.USER_USERNAME_PASSWORD_NOT_MATCHED;
    }
        else {
            MenuController.setUser(User.getUserByUserName(username));
            return LoginMenuResponses.USER_LOGIN_SUCCESSFUL;
        }
    }

    public LoginMenuResponses removeUser(String username, String password) {
        databaseController.refreshUsersFromFileJson();
        if (User.getUserByUserName(username) == null) return LoginMenuResponses.USER_USERNAME_PASSWORD_NOT_MATCHED;
        else if (!User.getUserByUserName(username).getPassWord().equals(password))
            return LoginMenuResponses.USER_USERNAME_PASSWORD_NOT_MATCHED;
        else {
            User.removeUserByUsername(username);
            databaseController.refreshUsersToFileJson();
            return LoginMenuResponses.USER_REMOVE_SUCCESSFUL;
        }
    }
}
