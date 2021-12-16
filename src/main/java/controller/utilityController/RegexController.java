package controller.utilityController;

import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexController {

    public static boolean registerRegex(String command, HashMap<String, String> info) {
        Matcher matcher = Pattern.compile("user create (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) ([\\w- ]+) (\\S+)").matcher(command);
        if (matcher.find()) {
            return isRegisterValid(matcher, info);
        } else return false;
    }

    private static boolean isRegisterValid(Matcher matcher, HashMap<String, String> info) {
        ArrayList<String> expectedParameters = new ArrayList<>();
        ArrayList<String> inputParameters = new ArrayList<>();
        inputParameters.add(matcher.group(1));
        inputParameters.add(matcher.group(3));
        inputParameters.add(matcher.group(5));
        inputParameters.add(matcher.group(7));
        expectedParameters.add("--username");
        expectedParameters.add("--password1");
        expectedParameters.add("--password2");
        expectedParameters.add("--email Address");
        if (inputParameters.containsAll(expectedParameters)) {
            info.put("username", matcher.group(2));
            info.put("password1", matcher.group(4));
            info.put("password2", matcher.group(6));
            info.put("email", matcher.group(8));
            return true;
        } else return false;
    }

    public static boolean enterMenuRegex(String command, HashMap<String, String> info) {
        Matcher matcher = Pattern.compile("menu enter (.+)$").matcher(command);
        if (matcher.find()){
            info.put("menuName",matcher.group(1));
            return true;
        }
        else return false;
    }

    public static boolean changePassRegex(HashMap<String, String> info, String command) {
        Matcher matcher = Pattern.compile("Profile --change (\\S+) (\\S+) (\\S+) (\\S+)").matcher(command);
        if (matcher.find()){
            return isChangePassFormatValid(info,matcher);
        }
        else return false;
    }

    private static boolean isChangePassFormatValid(HashMap<String, String> info, Matcher matcher) {
        ArrayList<String> expectedParameters = new ArrayList<>();
        ArrayList<String> inputParameters = new ArrayList<>();
        inputParameters.add(matcher.group(1));
        inputParameters.add(matcher.group(3));
        expectedParameters.add("--oldPassword");
        expectedParameters.add("--newPassword");
        if (expectedParameters.containsAll(inputParameters)){
            info.put("oldPass", matcher.group(2));
            info.put("newPass", matcher.group(4));
            return true;
        }
        else return false;
    }

    public static boolean changeUsernameRegex(HashMap<String, String> info, String command) {
        Matcher matcher = Pattern.compile("Profile --change (\\S+) (\\S+)").matcher(command);
        if (matcher.find()){
            return isChangeUsernameValid(info,matcher);
        }
        return false;
    }

    private static boolean isChangeUsernameValid(HashMap<String, String> info, Matcher matcher) {
        ArrayList<String>expectedParameters = new ArrayList<>();
        ArrayList<String>inputParamters = new ArrayList<>();
        expectedParameters.add("--username");
        inputParamters.add(matcher.group(1));
        if (expectedParameters.containsAll(inputParamters)){
            info.put("username",matcher.group(2));
            return true;
        }
        return false;
    }


    public boolean loginRegex(String command, HashMap<String, String> info) {
        Matcher matcher = Pattern.compile("user login (\\S+) (\\S+) (\\S+) (\\S+)").matcher(command);
        if (matcher.find()){
            return isLoginValid(matcher,info);
        }
        else return false;

    }

    private boolean isLoginValid(Matcher matcher, HashMap<String, String> info) {
        ArrayList<String> expectedParameters = new ArrayList<>();
        ArrayList<String> inputParameters = new ArrayList<>();
        inputParameters.add(matcher.group(1));
        inputParameters.add(matcher.group(3));
        expectedParameters.add("--username");
        expectedParameters.add("--password");
        if (expectedParameters.containsAll(inputParameters)){
            info.put("username",matcher.group(2));
            info.put("password",matcher.group(4));
            return true;
        }
        return false;
    }


    public static boolean isPasswordValid(String password) {
        Matcher matcher = Pattern.compile("(?=.*?[A-Z])(?=.*?[a-z])(?=.*?[0-9])(?=.*?[#?!@$%^&*-]).{8,32}").matcher(password);
        return matcher.find();
    }

    public static boolean isEmailValid(String email) {
        Matcher matcher = Pattern.compile("[A-Za-z0-9+_.-]+@(.+)").matcher(email);
        return matcher.find();
    }



}

