package view;

import controller.menusControllers.TeamMenuController;

public class TeamView extends MenuView{
    private static TeamView teamView = null;
    TeamMenuController teamMenuController = new TeamMenuController();


    public TeamView() {
        super("team menu");
    }

    public static TeamView getInstance() {
        if (teamView == null){
            teamView = new TeamView();
        }
        return teamView;
    }
    @Override
    public void run() {


    }
}
