package model;

import controller.utilityController.ImportExportController;

import java.util.HashMap;

public class User {
    private static HashMap<String, User> allUsers = new HashMap<>();
    private String name;
    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private long score;
    private String role;

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

    public static boolean doesUsernameExist(String username) {
        return getUserByUsername(username) == null;
    }


    public static HashMap<String, User> getAllUsers() {
        return allUsers;
    }

    public static void removeByUserName(String username) {
        allUsers.remove(username);
    }

    public static boolean emailDoesNotExist(String email) {
        for (String name : allUsers.keySet()) {
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

    public String getName() {
        return name;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public long getScore() {
        return score;
    }

    public String getRole() {
        return role;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public void setScore(long score) {
        this.score = score;
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

    public static void setAllUsers(HashMap<String, User> users) {
        allUsers = users;
    }

    @Override
    public String toString() {
        return "{ name='" + name + '\'' +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", email='" + email + '\'' +
                ", dateOfBirth='" + dateOfBirth + '\'' +
                ", score=" + score +
                ", role='" + role + '\'' +
                '}';
    }
}
