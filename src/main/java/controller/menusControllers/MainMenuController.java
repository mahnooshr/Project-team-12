package controller.menusControllers;

import view.*;

import java.util.HashMap;

public class MainMenuController extends MenuController {
    private static final HashMap<String, MenuView> allMenus = new HashMap<>();

    static {
        allMenus.put("Profile Menu", ProfileMenuView.getInstance());
        allMenus.put("Tasks Page", TasksMenuView.getInstance());
        allMenus.put("Teams Menu", TeamsMenuView.getInstance());
        allMenus.put("Notification Bar", NotificationBarView.getInstance());
        allMenus.put("Calender Menu", CalenderMenuView.getInstance());
    }


    public MainMenuController() {
        super("main menu");
    }


    public String menuEnter(String menuName) {
        if (allMenus.containsKey(menuName)) {
            return "menu enter successfully";
        } else return "menu name does not exists";
    }


    public HashMap<String, MenuView> getAllMenus() {
        return allMenus;
    }
}
