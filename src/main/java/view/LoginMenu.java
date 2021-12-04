package view;

import controller.Controller;
import controller.Regex;
public class LoginMenu extends Menu{
    public LoginMenu(String name, Menu parent) {
        super(name, parent);
    }

    @Override
    public void show() {
        System.out.println("----------" + this.name +"----------" );
        System.out.println("Write back to return");
    }

    @Override
    public void execute() {
        Matcher matcher;
        Menu nextMenu = this;
        String input = getInputFromUser();
        if(matcher=Regex.getMatcher(login, Regex.login).matches())
            userLogin(matcher);
        
}

public class LoginMenu {

    private void userLogin(Matcher matcher) {
String urername=matcher.group(1);
        String password=matcher.group(2);
        LoginController.loginuser(username,password);
    }


}
