package model;



import java.util.ArrayList;

public class User {
    private static ArrayList<User> allUsers;

    static {
        allUsers = new ArrayList<>();
    }

    private String activeDeckName;
    private ArrayList<String> passes;
    private String userName;
    private String passWord;
    private String Email;
    private int score;
    private int money;
    public enum UserType{
        ADMIN,
        MEMBER,
        TEAMLEADER,
    }
    public UserType userPermissions;
    public User(String userName, String passWord, String Email,UserType userType) {
        this.userName = userName;
        this.passWord = passWord;
        this.Email = Email;
        userPermissions = userType;
        passes=new ArrayList<>();
        passes.add(passWord);
    }

    public UserType getUserPermissions() {
        return userPermissions;
    }

    public void setUserPermissions(UserType userPermissions) {
        this.userPermissions = userPermissions;
    }

    public static User getUserByUserName(String userName) {
        for (User user : allUsers) {
            if (user.userName.equals(userName))
                return user;
        }
        return null;
    }

    public static void removeUserByUsername(String username) {
        for (User user : allUsers) {
            if (user.userName.equals(username)) {
                User.getAllUsers().remove(user);
                return;
            }
        }
    }

    public static User getUserByEmail(String email) {
        for (User user : allUsers) {
            if (user.getEmail().equals(email))
                return user;
        }
        return null;
    }

    public static ArrayList<User> getAllUsers() {
        return allUsers;
    }

    public static void setAllUsers(ArrayList<User> allUsers) {
        User.allUsers = allUsers;
    }



    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public void changeMoney(int amount) {
        this.setMoney(this.getMoney() + amount);
    }

    public ArrayList<String> getPasses() {
        return passes;
    }

    public void setPasses(ArrayList<String> passes) {
        this.passes = passes;
    }



    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }


    public String getActiveDeckName() {
        return activeDeckName;
    }

    public void setActiveDeckName(String activeDeckName) {
        this.activeDeckName = activeDeckName;
    }}


