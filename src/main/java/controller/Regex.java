package controller;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Regex {

    public static String createuser = "^user create --username (\\w+) --password1 (\\w+) --password2 (\\w+) --email Address (\\S+)$";
    public static String loginuser = "^user login --username (\\s+) --password (\\s+)$";
    public static String entermenu = "^enter menu (\\s+)$";
    public static String changepass = "^Profile --change --oldPassword (\\s+) --newPassword (\\s+)$";
    public static String changeusername = "^Profile --change --username (\\s+)$";
    public static String showteams = "Profile showTeams";
    public static String showteam = "^Profile showTeam (\\s+)$";
    public static String showprofile = "profile --show --myProfile";
    public static String showlogs = "profile --show logs";
    public static String shownotif = "profile --show notifications";
    public static String changetitle = "^edit --task --id (\\s+) --title (\\s+)$";
    public static String xhangedescription = "^edit --task --id (\\s+) --descriptions (\\s+)$";
    public static String changepriority = "^edit --task --id (\\s+) --priority (\\s+)$";
    public static String changedeadline = "^edit --task --id (\\s+) --Deadline (\\s+)$";
    public static String remove = "^edit --task --id (\\s+) --assignedUsers (\\s+) --remove$";
    public static String add = "^edit --task --id (\\s+) --assignedUsers (\\s+) --add$";
    public static String teamname = "^Enter Team (\\s+)$";
    public static String showscoreboard = "Scoreboard --show";
    public static String showroadmap = "Roadmap --show";
    public static String showchatroom = "Chatroom --show";
    public static String sendmessage = "^send message (\\s+)$";
    public static String showtasks = "show tasks";
    public static String showtask = "^show task --id(\\s+)$";
    public static String newboard = "^board --new --name (\\s+)$";
    public static String removeboard = "^board --remove --name (\\s+)$";
    public static String selectboard = "^board --select --name (\\s+)$";
    public static String deselectboard = "board --deselect";
    public static String addcategory = "^board --category (\\s+) --name (\\s+)$";
    public static String columncategory = "^board --category (\\s+) --column (\\s+) --name (\\s+)$";
    public static String doneboard = "^board --done --name (\\s+)$";
    public static String assaignboard = "^board --assaign (\\s+) --task (\\s+) --name (\\s+)$";
    public static String force = "^board --force --category (\\s+) --task (\\s+) --name (\\s+)$";
    public static String taskboardcategory = "^board --category (\\s+) --task (\\s+) --name (\\s+)$";
    public static String boardnameshow = "^board --show (\\s+) --name --board(\\s+)$";

    public static Matcher getMatcher(String input, String regex) {
        Pattern pattern = Pattern.compile(regex);
        return pattern.matcher(input);
    }
}

