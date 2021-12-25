package model;
import java.util.ArrayList;
import java.util.HashMap;

public class Team {
    private static final HashMap<String,Team>teams = new HashMap<>();
    private String name;
    private String leader;
    private final ArrayList<String>membersAsideFromLeader = new ArrayList<>();
    private final ArrayList<Task>teamTasks = new ArrayList<>();
    private Board board;
    private Chatroom chatroom;
    private RoadMap roadMap;


    public static Team getTeamByName(String name){
        return teams.get(name);
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setLeader(String leader) {
        this.leader = leader;
    }

    public void setBoard(Board board) {
        this.board = board;
    }

    public void setChatroom(Chatroom chatroom) {
        this.chatroom = chatroom;
    }

    public void setRoadMap(RoadMap roadMap) {
        this.roadMap = roadMap;
    }

    public String getName() {
        return name;
    }

    public String getLeader() {
        return leader;
    }

    public ArrayList<Task> getTeamTasks() {
        return teamTasks;
    }

    public Chatroom getChatroom() {
        return chatroom;
    }

    public Board getBoard() {
        return board;
    }

    public RoadMap getRoadMap() {
        return roadMap;
    }

    public static HashMap<String, Team> getTeams() {
        return teams;
    }

    public ArrayList<String> getMembersAsideFromLeader() {
        return membersAsideFromLeader;
    }
}
