package controller.menusControllers;

import model.Team;

public class TeamsMenuController extends MenuController {
    public TeamsMenuController() {
        super("Teams Menu");
    }


    public String teamEnter(String teamName) {
        if (Team.getTeamByName(teamName) == null) {
            return "team with name " + teamName + " does not exist";
        } else {
            return "team entered successfully";
        }
    }
}
