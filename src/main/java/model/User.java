package model;

import controller.utilityController.ImportExportController;

import java.util.ArrayList;
import java.util.HashMap;

public class User {
    private static HashMap<String, User> allUsers = new HashMap<>();
    private static ArrayList<String> myTasks = new ArrayList<>();////////////////
    private static ArrayList<String> memberTeams = new ArrayList<>();/////////////////
    private static ArrayList<String> leaderTeams = new ArrayList<>();/////////////////
    private String name;
    private String username;
    private String password;
    private String email;
    private String dateOfBirth;
    private long score;
    private String role;

    public User(String username, String password, String email) {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        setRole("member");
        setScore(0);
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

    public static void addTask(String task) {
        myTasks.add(task);
    }

    public static void addMemberTeam(String teamName) {
        memberTeams.add(teamName);
    }

    public static void addLeaderTeam(String teamName) {
        leaderTeams.add(teamName);
    }

    public static ArrayList<String> checkForUsersThatDoNotExist(ArrayList<String> users) {
        ArrayList<String> notGoodUsers = new ArrayList<>();
        for (String username : users) {
            if (!allUsers.containsKey(username)) {
                notGoodUsers.add(username);
            }
        }
        return notGoodUsers;
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

    public ArrayList<String> getMyTasks() {
        return myTasks;
    }

    public ArrayList<String> getMemberTeams() {
        return memberTeams;
    }

    public ArrayList<String> getLeaderTeams() {
        return leaderTeams;
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
        return "{ name='" + getName() + '\'' + '\n' +
                ", username='" + getUsername() + '\'' + '\n' +
                ", password='" + getPassword() + '\'' + '\n' +
                ", email='" + getEmail() + '\'' + '\n' +
                ", dateOfBirth='" + getDateOfBirth() + '\'' + '\n' +
                ", score=" + getScore() + '\n' +
                ", role='" + getRole() + '\'' + '\n' +
                '}';
    }
}
