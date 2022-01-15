package view;

import com.opencsv.exceptions.CsvValidationException;
import controller.menuController.LoginController;
import controller.responses.LoginMenuResponses;
import controller.Controller.UtilityController;

import java.io.IOException;
import java.util.HashMap;

public class LoginMenu extends Menu {
    private static LoginMenu loginMenu;
    LoginController loginController = new LoginController();
    LoginMenuResponses responses;
    private String username;
    private String password1;
    private String password2;
    private String email;
    {
        nextMenu = MainMenu.getInstance();
    }

    private LoginMenu() {
        super("Login Menu");
    }

    public static LoginMenu getInstance() {
        if (loginMenu == null)
            loginMenu = new LoginMenu();
        return loginMenu;
    }
public static void welcome()
{
   System.out.println("welcome to my program java 1.8.0_152!");
}
    @Override
    public void scanInput() throws IOException, CsvValidationException {
        while (true) {
            String input = UtilityController.getNextLine();
            if (input.startsWith("user create ")) checkAndCallRegister(input);
            else if (input.startsWith("user login ")) this.isEnter = checkAndCallLogin(input);
            else if (input.startsWith("user remove ")) checkAndCallRemove(input);
            else if (input.startsWith("menu enter ")) System.out.println("Navigation is not possible hear");
            else System.out.println("invalid command");
            if (isEnter) {
                isEnter = false;
                nextMenu.scanInput();
            }
            if (super.isExit) {
                super.isExit = false;
                return;
            }
        }
    }

    private void checkAndCallRegister(String input) {
        HashMap<String, String> enteredDetails = new HashMap<>();
        if (!regexController.createUserRegex(input, enteredDetails))
            System.out.println("invalid command");
        else {
            username = enteredDetails.get("username");
            password1 = enteredDetails.get("password1");
            password2 = enteredDetails.get("password2");
            email = enteredDetails.get("email");
            responses = loginController.registerUser(username, password1,password2,email);
            printResponse(responses);
        }
    }

    private boolean checkAndCallLogin(String input) {
        HashMap<String, String> enteredDetails = new HashMap<>();
        if (!regexController.loginUserRegex(input, enteredDetails))
            System.out.println("invalid command");
        else {
            responses = loginController.loginUser(enteredDetails.get("username"), enteredDetails.get("password"));
            printResponse(responses);
            return responses == LoginMenuResponses.USER_LOGIN_SUCCESSFUL;
        }
        return false;
    }

    private void checkAndCallRemove(String input) {
        HashMap<String, String> enteredDetails = new HashMap<>();
        if (!regexController.removeUserRegex(input, enteredDetails))
            System.out.println("invalid command");
        else {
            responses = loginController.removeUser(enteredDetails.get("username"), enteredDetails.get("password"));
            printResponse(responses);
        }
    }

    private void printResponse(LoginMenuResponses loginMenuResponses) {
        String output = "";
        switch (loginMenuResponses) {
            case USER_CREATE_SUCCESSFUL:
                output = "user created successfully!";
                break;
            case PASS_NOT_SAME:
                output = "Your passwords are not the same!";
                break;
            case USER_USERNAME_ALREADY_EXISTS:
                output = "user with username " + username + " already exists!";
                break;
            case USER_EMAIL_ALREADY_EXISTS:
                output = "User with this email already exists!";
                break;
            case EMAIL_IS_INVALID:
                output = "Email address is invalid!";
                break;
            case USER_LOGIN_SUCCESSFUL:
                output = "user logged in successfully!";
                break;
            case IS_NOT_USER:
                output = "There is not any user with username: "+username+"!";
                break;
            case USER_USERNAME_PASSWORD_NOT_MATCHED:
                output = "Username and password didn't match";
                break;
            case USER_LOGOUT_SUCCESSFUL:
                output = "user logged out successfully!";
                break;
            case USER_REMOVE_SUCCESSFUL:
                output = "user removed successfully!";
                break;
            case WELCOM:
                output = "welcome to my program java 1.8.0_152!";
                break;
            default:
                break;
        }
        System.out.println(output);
    }
}