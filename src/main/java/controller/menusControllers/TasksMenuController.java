package controller.menusControllers;

import model.Priority;
import model.Task;
import model.User;

import java.util.ArrayList;

public class TasksMenuController extends MenuController{

    public TasksMenuController() {
        super("tasks page");
    }

    public String changeTitleById(long id, String title) {
        Task task = Task.getTaskById(id);
        if (task!= null){
            if (!task.getLeader().equals(MenuController.getInstance().getActiveUser().getUsername())){
                return "you don't have access to do this action";
            }else {
                task.setTitle(title);
                return "title updated successfully";
            }
        }
        return "task with id " + id + " does not exist";
    }

    public String addUsersToTaskById(long id, ArrayList<String> users) {
        Task task = Task.getTaskById(id);
        if (task != null){
            if (!MenuController.getInstance().getActiveUser().getUsername().equals(task.getLeader())){
                return "you don't have access to do this action";
            }
            else
            {
                ArrayList<String> notGoodNames = User.checkForUsersThatDoNotExist(users);
                if (notGoodNames.size()!=0) {
                    task.addUsersToTask(users);
                    return "users " + users + " added successfully";
                }
                else{
                     return "there is not any users with usernames " + notGoodNames;
                }
            }

        }
        return "task with id " + id + " does not exist";
    }

    public String removeUsersByTaskId(long id, ArrayList<String> users) {
        Task task = Task.getTaskById(id);
        if (task != null){
            if (!MenuController.getInstance().getActiveUser().getUsername().equals(task.getLeader())){
                return "you don't have access to do this action";
            }
            else
            {
                ArrayList<String> notGoodNames = User.checkForUsersThatDoNotExist(users);
                if (notGoodNames.size()!=0) {
                    task.removeUsersFromTask(users);
                    return "users " + users + " removed successfully";
                }
                else{
                    return "there is not any users with usernames " + notGoodNames;
                }
            }

        }
        return "task with id " + id + " does not exist";
    }

    public String setDescriptionByTaskId(long id, String description) {
        Task task = Task.getTaskById(id);
        if (task!=null){
            if (!MenuController.getInstance().getActiveUser().getUsername().equals(task.getLeader())){
                return "you don't have access to this action";
            }
            else {
                task.setDescription(description);
                return "description changed successfully";
            }
        }
        else
            return "task with id " + id + " does not exist";
    }

    public String changePriorityById(long id, String priority) {
        Task task = Task.getTaskById(id);
        if (task!=null){
            if (!MenuController.getInstance().getActiveUser().getUsername().equals(task.getLeader())){
                return "you don't have access to this action";
            }
            else {
                try {
                    task.setPriority(Priority.valueOf(priority));
                    return "priority changed successfully";
                }catch (Exception e){
                    return "there is no priority with name " + priority;
                }
            }
        }
        else
            return "task with id " + id + " does not exist";
    }
}
