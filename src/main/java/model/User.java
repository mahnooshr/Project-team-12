package model;

import controller.utilityController.ImportExportController;

import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class User {
    private static HashMap<String, User> allUsers = new HashMap<>();
    private String username;
    private String password;
    private String email;



    public User() {

    }

    public User(String username, String password, String email) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        allUsers.put(username, this);
        ImportExportController.getInstance().refreshUsersToFileJson();
    }


    public static User getUserByUsername(String username) {
        return allUsers.get(username);
    }

    public static boolean isUsernameValid(String username) {
        return getUserByUsername(username) == null;
    }

    public static boolean isPasswordValid(String password) {
        Matcher matcher = Pattern.compile("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,32}").matcher(password);
        return matcher.find();
    }

    public static boolean isEmailValid(String email) {
        Matcher matcher = Pattern.compile("[A-Za-z0-9+_.-]+@(.+)").matcher(email);
        return matcher.find();
    }

    public static HashMap<String, User> getAllUsers() {
        return allUsers;
    }

    public static void removeByUserName(String username) {
        allUsers.remove(username);
    }

    public static boolean emailDoesNotExist(String email) {
        for (String name: allUsers.keySet()
        ) {
            if (allUsers.get(name).getEmail().equals(email)) return false;
        }
        return true;
    }

    public String getEmail() {
        return email;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public static void setAllUsers(HashMap<String, User>users){
        allUsers = users;
    }
}
