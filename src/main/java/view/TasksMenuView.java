package view;

import controller.menusControllers.TasksMenuController;
import controller.utilityController.RegexController;
import controller.utilityController.UtilController;

import java.util.ArrayList;
import java.util.HashMap;

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
        while (true) {
            UtilController.printString(this.getName() + "\n");
            String command = UtilController.getInput();
            if (command.contains("--title")) {
                checkChangeTitleRegex(command);
            } else if (command.contains("--descriptions")) {
                checkChangeDescriptionsRegex(command);
            } else if (command.contains("--priority")) {
                checkPriorityChangeRegex(command);
            } else if (command.contains("--Deadline")) {
                checkDeadLineChangeRegex(command);
            } else if (command.contains("--assignedUsers") && command.contains("--remove")) {
                checkRemoveUserRegex(command);
            } else if (command.contains("--assignedUsers") && command.contains("--add")) {
                checkAddUserRegex(command);
            } else if (command.equals("back")) {
                exit = true;
            } else {
                UtilController.printString("invalid command");
            }
            if (exit) {
                exit = false;
                return;
            }
        }

    }

    private void checkAddUserRegex(String command) {
        HashMap<String, ArrayList<String>> info = new HashMap<>();
        if (!regexController.addUserRegex(command, info)) {
            UtilController.printString("invalid command");
        } else {
            long id = Long.parseLong(String.valueOf(info.get("id")));
            ArrayList<String> users = info.get("users");
            UtilController.printString(tasksMenuController.addUsersToTaskById(id, users));
        }
    }

    private void checkRemoveUserRegex(String command) {
        HashMap<String, ArrayList<String>> info = new HashMap<>();
        if (!RegexController.removeUserRegex(command, info)) {
            UtilController.printString("invalid command");
        } else {
            long id = Long.parseLong(String.valueOf(info.get("id")));
            ArrayList<String> users = info.get("users");
            UtilController.printString(tasksMenuController.removeUsersByTaskId(id, users));
        }
    }

    ////////////////////////////
    private void checkDeadLineChangeRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!RegexController.deadlineRegex(command, info)) {
            UtilController.printString("invalid command");
        }
    }

    private void checkPriorityChangeRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!RegexController.priorityRegex(command, info)) {
            UtilController.printString("invalid command");
        } else {
            long id = Long.parseLong(info.get("id"));
            String priority = info.get("priority");
            UtilController.printString(tasksMenuController.changePriorityById(id, priority));
        }
    }

    private void checkChangeDescriptionsRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!RegexController.descriptionRegex(command, info)) {
            UtilController.printString("invalid command");
        } else {
            long id = Long.parseLong(info.get("id"));
            UtilController.printString(tasksMenuController.setDescriptionByTaskId(id, info.get("description")));
        }
    }

    private void checkChangeTitleRegex(String command) {
        HashMap<String, String> info = new HashMap<>();
        if (!RegexController.titleRegex(command, info)) {
            UtilController.printString("invalid command");
        } else {
            long id = Long.parseLong(info.get("id"));
            String title = info.get("title");
            UtilController.printString(tasksMenuController.changeTitleById(id, title));
        }
    }
}
