package view;

import controller.menusControllers.TeamMenuController;
import controller.utilityController.UtilController;

import java.util.HashMap;

public class TeamView extends MenuView {
    private static TeamMenuController teamMenuController;

    public TeamView(String name) {
        super(name);
        teamMenuController = new TeamMenuController(name);
    }

    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String getName() {
        return name;
    }

    @Override
    public void run() {
        while (true) {
            UtilController.printString(super.getName() + ":" + this.getName());
            String command = UtilController.getInput();
            if (command.contains("--show")) {
                checkSubMenuEnterRegex(command);
            } else if (command.startsWith("show task --id")) {
                checkShowTaskByID(command);
            } else if (command.equals("back")) {
                exit = true;
            } else if (command.equals("show tasks")){
                UtilController.printString(teamMenuController.showTasks());
            }
            else{
                UtilController.printString("invalid command");
            }
            if (enter) {
                enter = false;
                nextMenu.run();
            }
            if (exit) {
                exit = false;
                return;
            }

        }
    }

    private void checkShowTaskByID(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.showTaskByID(command, info)) {
            UtilController.printString("invalid command");
        } else {
            long id = Long.parseLong(info.get("id"));
            UtilController.printString(teamMenuController.showTaskByID(id));
        }
    }


    public void checkSubMenuEnterRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.enterSubMenuMatcher(command, info)) {
            UtilController.printString("invalid command");
        } else {
            String response = teamMenuController.menuEnter(info.get("menuName"));
            if (response.equals("subMenu entered successfully")) {
                nextMenu = teamMenuController.getAllMenus().get(info.get("menuName"));
                enter = true;
            }
            UtilController.printString(response);
        }
    }


}
