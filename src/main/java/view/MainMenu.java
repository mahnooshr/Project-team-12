package view;

import com.opencsv.exceptions.CsvValidationException;
import controller.menuController.MainMenuController;
import controller.responses.MainMenuResponses;
import controller.Controller.UtilityController;

import java.io.IOException;
import java.util.HashMap;

public class MainMenu extends Menu {
    private static MainMenu mainMenu;
    MainMenuController mainMenuController = new MainMenuController();
    MainMenuResponses responses;
    private MainMenu() {
        super("Main Menu");
    }

    public static MainMenu getInstance() {
        if (mainMenu == null)
            mainMenu = new MainMenu();
        return mainMenu;

    }

    @Override
    public void scanInput() throws IOException, CsvValidationException {
        responses=MainMenuResponses.ENTER_SUCCESSFULLY;
        printResponse(responses);
        responses=MainMenuResponses.SHOW_MENU;
        printResponse(responses);
        while (true) {
            String input = UtilityController.getNextLine();
             if (input.equals("user logout")) checkAndCallLogout(input);
            else if (input.startsWith("enter menu")) checkAndCallMenuEnter(input);
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

    private void checkAndCallLogout(String input) {
        responses = mainMenuController.logout();
        printResponse(responses);
        if (responses == MainMenuResponses.USER_LOGOUT_SUCCESSFUL) {
            super.isExit = true;
        }
    }


    private void checkAndCallMenuEnter(String input) {
        HashMap<String, String> enteredDetails = new HashMap<>();
        if (!regexController.enterMenuRegex(input, enteredDetails))
            System.out.println("invalid command");
        else {
            responses = mainMenuController.menuEnter(enteredDetails.get("menuName"));
            if (responses == MainMenuResponses.MENU_ENTER_SUCCESSFUL) {
                nextMenu = MainMenuController.getAllMenus().get(enteredDetails.get("menuName"));
                isEnter = true;
            }

        }
    }



    private void printResponse(MainMenuResponses mainMenuResponses) {
        String output = "";
        switch (mainMenuResponses) {
            case USER_LOGOUT_SUCCESSFUL:
                output = "user logged out successfully!";
                break;
            case MENU_NAME_NOT_EXIST:
                output = "menu name you entered doesn't exist!";
                break;
            case MENU_ENTER_SUCCESSFUL:
                output = "entered menu"+nextMenu.menuName+"...";
                break;
            case MENU_NAVIGATION_NOT_POSSIBLE:
                output = "menu navigation is not possible";
                break;
            case ENTER_SUCCESSFULLY:
                output = "Welcome to the Main Menu!";
                break;
            case SHOW_MENU:
                output = "1.Profile Menu\n2.Team Menu\n3.Tasks Page\n4.Calendar Menu\n5.Notification Bar";
                break;
            default:
                break;
        }
        System.out.println(output);
    }
}



