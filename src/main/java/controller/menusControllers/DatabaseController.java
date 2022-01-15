package controller.Controller;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import model.User;


import java.io.*;
import java.lang.reflect.Type;
import java.util.ArrayList;

public class DatabaseController {
    private static DatabaseController databaseController;
    public static DatabaseController getInstance() {
        if (databaseController == null)
            databaseController = new DatabaseController();
        return databaseController;
    }

public void creatAdmin(){
    User.getAllUsers().add(new User("Mahnoosh","Mandana1377","mahnoosh@yahoo.com", User.UserType.ADMIN));
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
        GsonBuilder gsonBuilder = new GsonBuilder();
        try (Reader reader = new FileReader("src/main/resources/Users.json")) {
            Type usersListType = new TypeToken<ArrayList<User>>() {
            }.getType();
        } catch (IOException e) {
            System.out.println("welcome to my program java 1.8.0_152!");
        }
    }
}
