package controller.utilityController;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import model.Task;
import model.User;
import com.google.gson.reflect.TypeToken;
import java.io.*;
import java.lang.reflect.Type;
import java.util.HashMap;

public class ImportExportController {
    private static ImportExportController importExportController = null;

    public static ImportExportController getInstance() {
        if (importExportController == null)
            importExportController = new ImportExportController();
        return importExportController;
    }


    public void refreshUsersToFileJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("src/main/resources/Users.json")) {
            gson.toJson(User.getAllUsers(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public void refreshUsersFromFileJson() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/main/resources/Users.json")) {
            Type type = new TypeToken<HashMap<String, User>>(){}.getType();
            User.setAllUsers(gson.fromJson(reader, type));
        } catch (IOException e) {
            //e.printStackTrace();
        }finally {
            System.out.println("Welcome to this Game!\nFrom: Group12 AP- 2021 Fall");
        }
    }


    public void refreshTasksToFileJson() {
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        try (Writer writer = new FileWriter("src/main/resources/Tasks.json")) {
            gson.toJson(Task.getTasks(), writer);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void refreshTasksFromFileJson() {
        Gson gson = new Gson();
        try (Reader reader = new FileReader("src/main/resources/Tasks.json")) {
            Type type = new TypeToken<HashMap<Long, Task>>(){}.getType();
            Task.setTasks(gson.fromJson(reader, type));
        } catch (IOException e) {
            //e.printStackTrace();
        }
    }

}
