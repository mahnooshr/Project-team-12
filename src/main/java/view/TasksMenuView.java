package view;

import controller.menusControllers.TasksMenuController;

public class TasksMenuView extends MenuView {
    private static TasksMenuView tasksMenuView = null;
    TasksMenuController tasksMenuController = new TasksMenuController();

    public TasksMenuView() {
        super("tasks page");
    }

    public static TasksMenuView getInstance() {
        if (tasksMenuView == null) {
            tasksMenuView = new TasksMenuView();
        }
        return tasksMenuView;
    }

    @Override
    public void run() {

    }
}
