package view;

import controller.Controller;
import controller.Regex;

public class WelcomeMenu {

    private void userLogin(String userName, String password) {

    }


    public void run() {
        Controller controller = Controller.getInstance();
        while (true) {
            System.out.println(Response.welcome + "\n" +
                    "please write one of the numbers to say your command:\n" +
                    "1- login\n" +
                    "2- register");
            String command = controller.getInput();
            if (command.equals("1")){

                System.out.println("please enter your information as follows:\n" +
                        "user create --username <username> --password1 <password> --password2 <password> --email <email>\n");
                System.out.println(Controller.register(controller.getInput()));
            }else if (command.equals("2")){
                System.out.println("please enter your information as follows:\n" +
                        "user login --username <username> --password <password>");
            }else if (command.equals("end"))
            {
                break;
            }
            else {
                System.out.println("Invalid command. Please try again.");
            }
        }
    }
}
