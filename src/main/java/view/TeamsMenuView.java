package view;

import controller.menusControllers.MenuController;
import controller.menusControllers.TeamsMenuController;
import controller.utilityController.UtilController;

import java.util.ArrayList;
import java.util.HashMap;

public class TeamsMenuView extends MenuView {
    private static TeamsMenuView teamsMenuView = null;
    TeamsMenuController teamsMenuController = new TeamsMenuController();

    public TeamsMenuView() {
        super("teams menu");
    }

    public static TeamsMenuView getInstance() {
        if (teamsMenuView == null) {
            teamsMenuView = new TeamsMenuView();
        }
        return teamsMenuView;
    }

    @Override
    public void run() {
        while (true) {
            UtilController.printString(this.getName());
            UtilController.printString(showTeams());
            String command = UtilController.getInput();
            if (command.startsWith("Enter team")) {
                checkEnterTeamRegex(command);
            } else if (command.equals("back")) {
                exit = true;
            } else {
                UtilController.printString("invalid command");
            }
            if (exit) {
                exit = false;
                return;
            }
            if (enter) {
                enter = false;
                nextMenu.run();
            }
        }
    }

    private void checkEnterTeamRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!regexController.teamEnterRegex(info, command)) {
            UtilController.printString("invalid command");
        } else {
            String teamName = info.get("teamName");
            String response = teamsMenuController.teamEnter(teamName);
            if (response.equals("team entered successfully")) {
                nextMenu = new TeamView(teamName);
                enter = true;
            }
            UtilController.printString(response);
        }
    }

    private String showTeams() {
        StringBuilder str = new StringBuilder();
        ArrayList<String> teams = MenuController.getInstance().getActiveUser().getMemberTeams();
        for (int i = 0; i < teams.size(); i++) {
            str.append(i + 1).append(" ").append(teams.get(i)).append("\n");
        }
        return String.valueOf(str);
    }
}
