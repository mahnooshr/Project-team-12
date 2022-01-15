package controller.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexController {
    public Boolean createUserRegex(String input, HashMap<String, String> enteredDetails) {
        Matcher matcher = getCommandMatcher(input, "user create (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+) (\\S+)$");
        if (matcher.find()) {
            return isCreateUserCommandValid(matcher, enteredDetails);
        } else return false;
    }
public  static Boolean newPassRegex(String newPass)
{

    if(newPass.matches("[A-Z+0-9+a-z]{8,}"))
        return true;
    else
        return false;
}
public static Boolean newUsernameRegex(String userName)
{
    if(userName.chars().count()<4)
        return false;
    else return true;
}
    public static Boolean newUsernameRegex2(String userName)
    {
        if(userName.matches("[A-Za-z0-9_]*"))
            return true;
        else return false;
    }
    public Boolean isCreateUserCommandValid(Matcher matcher, HashMap<String, String> enteredDetails) {
        boolean commandValidation = true;
        CommandCase commandCase;
        HashMap<String, String> inputParameters = new HashMap();
        inputParameters.put(matcher.group(1), matcher.group(2));
        inputParameters.put(matcher.group(3), matcher.group(4));
        inputParameters.put(matcher.group(5), matcher.group(6));
        inputParameters.put(matcher.group(7), matcher.group(9));
        ArrayList<String> longCommandParameters = new ArrayList<>();
        longCommandParameters.add("--username");
        longCommandParameters.add("--password1");
        longCommandParameters.add("--password2");
        longCommandParameters.add("--email");
        ArrayList<String> shortCommandParameters = new ArrayList<>();
        shortCommandParameters.add("-u");
        shortCommandParameters.add("-p");
        shortCommandParameters.add("-p2");
        shortCommandParameters.add("-e");
        if (inputParameters.keySet().containsAll(longCommandParameters) && longCommandParameters.containsAll(inputParameters.keySet()))
            commandCase = CommandCase.LONG;
        else if (inputParameters.keySet().containsAll(shortCommandParameters) && shortCommandParameters.containsAll(inputParameters.keySet()))
            commandCase = CommandCase.SHORT;
        else {
            commandCase = CommandCase.INVALID;
            commandValidation = false;
        }
        if (commandCase.equals(CommandCase.LONG)) {
            enteredDetails.put("username", inputParameters.get("--username"));
            enteredDetails.put("password1", inputParameters.get("--password1"));
            enteredDetails.put("password2", inputParameters.get("--password2"));
            enteredDetails.put("email", inputParameters.get("--email"));
        } else if (commandCase.equals(CommandCase.SHORT)) {
            enteredDetails.put("username", inputParameters.get("-u"));
            enteredDetails.put("password1", inputParameters.get("-p"));
            enteredDetails.put("password2", inputParameters.get("-p2"));
            enteredDetails.put("email", inputParameters.get("-e"));
        }
        return commandValidation;
    }



    public Boolean loginUserRegex(String input, HashMap<String, String> enteredDetails) {
        Matcher matcher = getCommandMatcher(input, "user login (\\S+) (\\S+) (\\S+) (\\S+)$");
        if (matcher.find()) {
            return isLoginUserCommandValid(matcher, enteredDetails);
        } else return false;
    }

    public Boolean removeUserRegex(String input, HashMap<String, String> enteredDetails) {
        Matcher matcher = getCommandMatcher(input, "user remove (\\S+) (\\S+) (\\S+) (\\S+)$");
        if (matcher.find()) {
            return isLoginUserCommandValid(matcher, enteredDetails);
        } else return false;
    }

    public Boolean isLoginUserCommandValid(Matcher matcher, HashMap<String, String> enteredDetails) {
        boolean commandValidation = true;
        CommandCase commandCase;
        HashMap<String, String> inputParameters = new HashMap();
        inputParameters.put(matcher.group(1), matcher.group(2));
        inputParameters.put(matcher.group(3), matcher.group(4));
        ArrayList<String> longCommandParameters = new ArrayList<>();
        longCommandParameters.add("--username");
        longCommandParameters.add("--password");
        ArrayList<String> shortCommandParameters = new ArrayList<>();
        shortCommandParameters.add("-u");
        shortCommandParameters.add("-p");
        if (inputParameters.keySet().containsAll(longCommandParameters) && longCommandParameters.containsAll(inputParameters.keySet()))
            commandCase = CommandCase.LONG;
        else if (inputParameters.keySet().containsAll(shortCommandParameters) && shortCommandParameters.containsAll(inputParameters.keySet()))
            commandCase = CommandCase.SHORT;
        else {
            commandCase = CommandCase.INVALID;
            commandValidation = false;
        }
        if (commandCase.equals(CommandCase.LONG)) {
            enteredDetails.put("username", inputParameters.get("--username"));
            enteredDetails.put("password", inputParameters.get("--password"));
        } else if (commandCase.equals(CommandCase.SHORT)) {
            enteredDetails.put("username", inputParameters.get("-u"));
            enteredDetails.put("password", inputParameters.get("-p"));
        }
        return commandValidation;
    }

    public Boolean enterMenuRegex(String input, HashMap<String, String> enteredDetails) {
        Matcher matcher = getCommandMatcher(input, "enter menu (.+)$");
        if (matcher.find()) {
            enteredDetails.put("menuName", matcher.group(1));
            return true;
        } else return false;
    }

    public Boolean changeUsernameRegex(String input, HashMap<String, String> enteredDetails) {
        Matcher matcher = getCommandMatcher(input, "Profile --change --username (\\S+)$");
        if (matcher.find()) {
            enteredDetails.put("username", matcher.group(1));
            return true;
        } else return false;
    }


    public Boolean changePasswordRegex(String input, HashMap<String, String> enteredDetails) {
        if (input.contains("Password")) {
            input = input.replaceAll("Password", "");
            Matcher matcher = getCommandMatcher(input, "Profile --change (\\S+) (\\S+) (\\S+) (\\S+)$");
            if (matcher.find())
                return isChangePasswordCommandValid(matcher, enteredDetails);
            else return false;
        } else return false;

    }

    public Boolean isChangePasswordCommandValid(Matcher matcher, HashMap<String, String> enteredDetails) {
        boolean commandValidation = true;
        CommandCase commandCase;
        HashMap<String, String> inputParameters = new HashMap();
        inputParameters.put(matcher.group(1), matcher.group(2));
        inputParameters.put(matcher.group(3), matcher.group(4));
        ArrayList<String> longCommandParameters = new ArrayList<>();
        longCommandParameters.add("--old");
        longCommandParameters.add("--new");
        ArrayList<String> shortCommandParameters = new ArrayList<>();
        shortCommandParameters.add("-o");
        shortCommandParameters.add("-n");
        if (longCommandParameters.containsAll(inputParameters.keySet()) && inputParameters.keySet().containsAll(longCommandParameters))
            commandCase = CommandCase.LONG;
        else if (inputParameters.keySet().containsAll(shortCommandParameters) && shortCommandParameters.containsAll(inputParameters.keySet()))
            commandCase = CommandCase.SHORT;
        else {
            commandCase = CommandCase.INVALID;
            commandValidation = false;
        }
        if (commandCase.equals(CommandCase.LONG)) {
            enteredDetails.put("old", inputParameters.get("--old"));
            enteredDetails.put("new", inputParameters.get("--new"));
        } else if (commandCase.equals(CommandCase.SHORT)) {
            enteredDetails.put("old", inputParameters.get("-o"));
            enteredDetails.put("new", inputParameters.get("-n"));
        }
        return commandValidation;
    }



    private Matcher getCommandMatcher(String command, String regex) {
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(command);
        return matcher;
    }

    enum CommandCase {
        SHORT,
        LONG,
        INVALID
    }

}
