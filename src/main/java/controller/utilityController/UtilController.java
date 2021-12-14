package controller.utilityController;

import java.util.Scanner;

public class UtilController {
    private static Scanner scanner;

    public static void initializeScanner() {
        scanner = new Scanner(System.in);
    }

    public static String getInput() {
        return scanner.nextLine();
    }

    public static void printString(String input) {
        System.out.println(input);
    }

}