package controller;


import java.util.Scanner;

public class Controller
{
    Controller controller;
    Scanner scanner;

    public Controller getInstance() {
        if (controller == null){
            controller = new Controller();
            scanner = new Scanner(System.in);
        }
        return controller;
    }

    private String getInput()
    {
        return scanner.nextLine();
    }
}
