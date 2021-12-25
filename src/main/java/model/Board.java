package model;

import java.util.ArrayList;
import java.util.HashMap;

public class Board {
    int phase;
    String name;
    String teamName;
    String leader;
    HashMap<String, ArrayList<String>> categoriesAndTasks = new HashMap<>();
    ArrayList<Task> tasks;
    HashMap<String, Board> boards = new HashMap<>();

    public String getName() {
        return name;
    }

    public int getPhase() {
        return phase;
    }

    public String getTeamName() {
        return teamName;
    }


    public String getLeader() {
        return leader;
    }

    @Override
    public String toString() {

        return ("Board name:" + getName() +
                "\nBoard completion:" + getDonePercentage() +
                "\nBoard failed:" + getFailedPercentage() +
                "\nBoard leader:" + getLeader() +
                "\nBoard tasks:\n" + showTasks());
    }

    private float getFailedPercentage() {
        return (float) (categoriesAndTasks.get("failed").size() / categoriesAndTasks.size());
    }

    private float getDonePercentage() {
        return (float) (categoriesAndTasks.get("done").size() / categoriesAndTasks.size());
    }


    public String showTasks() {
        ArrayList<Task> allTasks = new ArrayList<>(tasks);
        return Task.sortAndShow(tasks);
    }

}
