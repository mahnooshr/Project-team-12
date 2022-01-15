package controller.Controller;


import java.util.Scanner;

public class ScannController {
    private static Scanner scanner;

    public static void Scanner() {
        scanner = new Scanner(System.in);
    }

    public static String getNextLine() {
        return scanner.nextLine();
    }

    public static void printString(String input) {
        System.out.println(input);
    }


}
