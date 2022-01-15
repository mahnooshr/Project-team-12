package view;

import controller.menuController.ProfileController;
import controller.responses.ProfileMenuResponses;
import controller.Controller.UtilityController;

import java.util.HashMap;

public class ProfileMenu extends Menu {
    private static ProfileMenu profileMenu;
    ProfileController profileController = new ProfileController();
    String newPassword;
    ProfileMenuResponses responses;
    private ProfileMenu() {
        super("Profile Menu");
    }

    public static ProfileMenu getInstance() {
        if (profileMenu == null)
            profileMenu = new ProfileMenu();
        return profileMenu;
    }

    @Override
    public void scanInput() {
        while (true) {
            String input = UtilityController.getNextLine();
            if (input.startsWith("Profile --change --oldPassword")) checkAndCallChangePassword(input);
            else if (input.startsWith("Profile --change --username")) checkAndCallChangeUsername(input);
            else if (input.startsWith("Profile --change --username")) checkAndCallChangeUsername(input);
            else System.out.println("invalid command");
            if (super.isExit) {
                super.isExit = false;
                return;
            }
        }

    }


    private int turn=0;
    public void checkAndCallChangePassword(String input) {
        HashMap<String, String> enteredDetails = new HashMap<>();
        if (!regexController.changePasswordRegex(input, enteredDetails))
            System.out.println("invalid command");
        else {


            String currentPassword = enteredDetails.get("old");
            String newPassword = enteredDetails.get("new");
            responses = profileController.changePassword(currentPassword , newPassword);
            if(responses==ProfileMenuResponses.CURRENT_PASSWORD_INVALID)
                turn++;
            else
                turn=0;
            if(turn==2)
                super.isExit=true;
            printResponse(responses);
        }

    }
    public void checkAndCallChangeUsername(String input) {
        HashMap<String, String> enteredDetails = new HashMap<>();
        if (!regexController.changeUsernameRegex(input, enteredDetails))
            System.out.println("invalid command");
        else {

            String newUsername = enteredDetails.get("username");
            responses = profileController.changeUsername(newUsername);
            if(responses==ProfileMenuResponses.CURRENT_PASSWORD_INVALID)
                turn++;
            else
                turn=0;
            if(turn==2)
                super.isExit=true;
            printResponse(responses);
        }

    }
    private void printResponse(ProfileMenuResponses profileMenuResponses)
    {
        String output = "";
        switch (profileMenuResponses) {
            case PASSWORD_CHANGE_SUCCESSFUL:
                output = "password changed successfully!";
                break;
            case IDENTICAL_PASSWORDS:
                output = "please type a new password!";
                break;
            case CURRENT_PASSWORD_INVALID:
                output = "wrong old password!";
                break;
            case PASS_NOT_STRONG:
                output = "Please Choose A strong Password (Containing at least 8 characters including 1 digit and 1 Capital Letter)";
                break;
            case USER_ALREADY_TAKEN:
                output = "username already taken!";
                break;
            case INCLOUD_ATLEAST_CHAR:
                output = "Your new username must include at least 4 characters!";
                break;
            case COUNTAINS_SPECIAL_CHAR:
                output = "New username contains Special Characters! Please remove them and try again!";
                break;
            case SAME_USENAME:
                output = "you already have this username!";
                break;
            case USERNAME_CHANGE_SUCCESSFUL:
                output = "you already have this username!";
                break;
            default:
                break;
        }
        System.out.println(output);
    }
}

