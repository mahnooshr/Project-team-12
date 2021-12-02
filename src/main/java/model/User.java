package model;


import java.util.ArrayList;
import java.util.HashMap;

public class User
{
    private String username;
    private String password;
    private String email;
    private boolean isLoggedIn;
    private String role;
    private int score;
    private ArrayList<String> teamNames;
    private ArrayList<String> joinedTeams;
    private ArrayList<Integer>tasks;
    private final HashMap<String, User> allUsers = new HashMap<>();


    public User(){

    }

    public User(String password, String username, String email)
    {
        setUsername(username);
        setPassword(password);
        setEmail(email);
        allUsers.put(username, this);
    }

    private User(String password)
    {

    }


    public HashMap<String, User> getAllUsers() {
        return allUsers;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    public void setLoggedIn(boolean loggedIn) {
        isLoggedIn = loggedIn;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public ArrayList<String> getTeamNames() {
        return teamNames;
    }

    public void setTeamNames(ArrayList<String> teamNames) {
        this.teamNames = teamNames;
    }

    public ArrayList<String> getJoinedTeams() {
        return joinedTeams;
    }

    public void setJoinedTeams(ArrayList<String> joinedTeams) {
        this.joinedTeams = joinedTeams;
    }

    public ArrayList<Integer> getTasks() {
        return tasks;
    }

    public void setTasks(ArrayList<Integer> tasks) {
        this.tasks = tasks;
    }

    public void setUsername(String username) {
        this.username = username;
    }
}
