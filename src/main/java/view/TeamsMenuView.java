package view;

import controller.menusControllers.TeamMenuController;

public class TeamsMenuView extends MenuView{
    private static TeamsMenuView teamsMenuView = null;
    TeamMenuController teamMenuController = new TeamMenuController();
    public TeamsMenuView() {
        super("teams menu");
    }

    public static TeamsMenuView getInstance() {
        if (teamsMenuView == null){
            teamsMenuView = new TeamsMenuView();
        }
        return teamsMenuView;
    }
    @Override
    public void run() {

    }
}
