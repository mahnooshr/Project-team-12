package controller.menuController;

import controller.responses.MainMenuResponses;
import view.*;

import java.util.HashMap;

public class MainMenuController extends MenuController {
    private static final HashMap<String, Menu> allMenus = new HashMap<>();
    static {

    }
    public MainMenuController() {
        super("Main Menu");
    }

    public static HashMap<String, Menu> getAllMenus() {
        return allMenus;
    }

    public MainMenuResponses menuEnter(String menuName) {
        if (allMenus.containsKey(menuName))
            return MainMenuResponses.MENU_ENTER_SUCCESSFUL;
        else return MainMenuResponses.MENU_NAME_NOT_EXIST;
    }
    public MainMenuResponses logout() {
        return MainMenuResponses.USER_LOGOUT_SUCCESSFUL;
    }

}
