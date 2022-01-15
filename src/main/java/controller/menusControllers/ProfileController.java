package controller.menuController;

import controller.responses.ProfileMenuResponses;
import controller.Controller.RegexController;

public class ProfileController extends MenuController {
    public ProfileController() {
        super("Profile Menu");
    }

    public ProfileMenuResponses changePassword(String userPassword, String newPassword) {
        if (!user.getPassWord().equals(userPassword)){
            return ProfileMenuResponses.CURRENT_PASSWORD_INVALID;

        }
        else if (user.getPasses().contains(newPassword))
            return ProfileMenuResponses.IDENTICAL_PASSWORDS;
        else if (RegexController.newPassRegex(newPassword))
            return ProfileMenuResponses.PASS_NOT_STRONG;

        else {

            user.setPassWord(newPassword);
            databaseController.refreshUsersToFileJson();
            return ProfileMenuResponses.PASSWORD_CHANGE_SUCCESSFUL;
        }
    }



    public ProfileMenuResponses changeUsername( String newUsername) {
        if(!RegexController.newUsernameRegex(newUsername))
            return ProfileMenuResponses.INCLOUD_ATLEAST_CHAR;
        else if (!user.getUserName().equals(newUsername)){
            return ProfileMenuResponses.USER_ALREADY_TAKEN;

        }
        else if (!RegexController.newUsernameRegex2(newUsername)){
            return ProfileMenuResponses.COUNTAINS_SPECIAL_CHAR;

        }
        else if (user.getUserName().equals(newUsername))
            return ProfileMenuResponses.SAME_USENAME;
        else {
            user.setUserName(newUsername);
            databaseController.refreshUsersToFileJson();
            return ProfileMenuResponses.USERNAME_CHANGE_SUCCESSFUL;
        }
    }
}

