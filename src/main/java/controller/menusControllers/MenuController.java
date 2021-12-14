package controller.menusControllers;

import model.User;

public class MenuController {
    private static MenuController menuController = null;
    private String name;
    private User activeUser;

    public MenuController(String name) {
        this.name = name;
        menuController = this;
    }

    public static MenuController getInstance() {
        if (menuController == null)
            menuController = new MenuController("Menu");
        return menuController;
    }

    public User getActiveUser() {
        return activeUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setActiveUser(User activeUser) {
        this.activeUser = activeUser;
    }
}
