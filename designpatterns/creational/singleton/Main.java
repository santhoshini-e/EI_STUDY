package designpatterns.creational.singleton;

import java.util.Scanner;

/**
 * Main class to demonstrate Logger Singleton pattern with user input.
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Logger logger = Logger.getInstance();

        System.out.println("=== Simple Logger Demo ===");
        System.out.println("Type your log messages (type 'exit' to quit):");

        String userInput;
        do {
            System.out.print("Enter log message: ");
            userInput = scanner.nextLine();

            if (!userInput.equalsIgnoreCase("exit")) {
                logger.log(userInput);
            }

        } while (!userInput.equalsIgnoreCase("exit"));

        scanner.close();
        System.out.println("Logger completed.");
    }
}