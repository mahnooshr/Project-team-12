package model;


import java.util.ArrayList;

public class User
{
    private String username;
    private String password;
    private String email;
    private boolean isloggedIn;
    private String role;
    private int score;
    private ArrayList<String> teamNames;
    private ArrayList<String> joinedTeams;
    private ArrayList<Integer>tasks;






    private User(String password, String username, String email)
    {

    }

    private User(String password)
    {

    }


    private  boolean validatePass(String password)
    {
        return false;
    }


    private  boolean validateUserName(String username)
    {
        return false;
    }

}
