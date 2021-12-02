package controller;


import model.User;
import view.Response;


import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;
import java.util.regex.Matcher;

public class Controller {
    private static Controller controller;
    private static Scanner scanner;
    private User currentUser;
    public static Controller getInstance() {
        if (controller == null) {
            controller = new Controller();
            scanner = new Scanner(System.in);
        }
        return controller;
    }

    public String getInput() {
        return scanner.nextLine();
    }


    public static String register(String info) {
        Matcher matcher = Regex.getMatcher(info, Regex.createuser);
        if (matcher.find()) {
            String username = matcher.group(1);
            String password1 = matcher.group(2);
            String password2 = matcher.group(3);
            String email = matcher.group(4);
            if(!validateUserName(username)) return Response.sameusername;
            if (!validateSamePassword(password1, password2)) return Response.notsamepass;
            if (!validateStrongPassword(password1)) return Response.strongPass;
            if (!validateValidEmail(email))return Response.invalidemail;
            if (!validateNotSameEmail(email)) return Response.sameemail;
            User user = new User(username,password1,email);
            return Response.successfulregistration;
        }
        return "invalid command format";
    }

    private static boolean validateNotSameEmail(String email) {
        HashMap<String, User> user = new User().getAllUsers();
        for (String name: user.keySet()
             ) {
            if (user.get(name).getEmail().equals(email)) return false;
        }
        return true;
    }

    private static boolean validateStrongPassword(String password1) {
        Matcher matcher = Regex.getMatcher(password1, "^(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,32}$");
        return matcher.find();
    }

    private static boolean validateValidEmail(String email) {
        Matcher matcher = Regex.getMatcher(email, "^[A-Za-z0-9+_.-]+@(.+)$");
        return matcher.find();
    }


    public static boolean validateSamePassword(String password1, String password2) {
        return password1.equals(password2);
    }


    public static boolean validateUserName(String username) {
        Set<String> users = new User().getAllUsers().keySet();
        for (String usernames: users) {
            if (usernames.equals(username)) return false;
        }
        return true;
    }


}
