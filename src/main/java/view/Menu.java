package view;

import com.opencsv.exceptions.CsvValidationException;
import controller.Controller.ScannController;
import controller.menuController.MenuController;
import controller.Controller.RegexController;
import controller.Controller.ScannController;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public abstract class Menu {
    static {
        ScannController.Scanner();
    }

    private final MenuController menuController;
    protected String menuName;
    protected Menu nextMenu;
    protected boolean isExit = false;
    protected boolean isEnter = false;
    RegexController regexController = new RegexController();
    private MenuController.MenuResponse MenuControllerResponse;

    public Menu(String menuName) {
        this.setMenuName(menuName);
        menuController = new MenuController("Menu");
    }

    public abstract void scanInput() throws IOException, CsvValidationException;



    protected Matcher getCommandMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }



    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }
}
