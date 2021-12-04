
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
                if (user.getUsername().equals(username) )
                    activeUser = user;
    
                }
            }
            if (activeUser == null) {
                System.out.println(view.Response.nousernameexist+username+"!");
                return false;
            }
      if (!activeUser.getPassword.equals(password)) {
                System.out.println(view.Response.nonmatch);
                return false;
            }
            else {
                User.getAllUsers().replace(activeUser, true);
                System.out.println(view.Response.successfullylogin);
                return true;
            }
        }
    }}
