package view;

import controller.menusControllers.MenuController;
import controller.utilityController.RegexController;
import controller.utilityController.UtilController;

public abstract class MenuView {
    static{
        UtilController.initializeScanner();
    }
    protected String name;
    protected MenuView nextMenu;
    protected boolean enter;
    protected boolean exit;
    RegexController regexController = new RegexController();
    private MenuController menuController;

    public MenuView(String name){
        setName(name);
        menuController = new MenuController("Menu");
    }

    public abstract void run();



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
