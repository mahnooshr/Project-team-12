package view;

import controller.menusControllers.ScoreboardController;

public class ScoreboardView extends MenuView{
    private static ScoreboardView scoreboardView = null;
    ScoreboardController scoreboardController = new ScoreboardController();
    public ScoreboardView() {
        super("Scoreboard menu");
    }

    public static ScoreboardView getInstance() {
        if(scoreboardView == null){
            scoreboardView = new ScoreboardView();
        }
        return scoreboardView;
    }

    @Override
    public void run() {

    }
}
