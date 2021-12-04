
package controller;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
public class Controller {
   public boolean loginuser(String username, String password) {
        User activeUser = findLoggedInUser();
        if (activeUser != null) {
            System.out.println("You must logout first!!!");
            return false;
        } else {
            for (User user : User.getAllUsers().keySet()) {
                if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                    activeUser = user;
                }
            }
            if (activeUser == null) {
                System.out.println("Username or password is wrong!!!");
                return false;
            }
            else {
                User.getAllUsers().replace(activeUser, true);
                System.out.println("" + activeUser.getUsername() + " has logged in successfully");
                return true;
            }
        }
    }}
