package designpatterns.structural.adapter;

import java.util.Scanner;

/**
 * Demonstration class for the Adapter pattern.
 */
public class MessageDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Create adapters and modern services
        MessageSender emailAdapter = new EmailAdapter();
        MessageSender smsSender = new SMSSender();

        System.out.println("=== Message System Demo ===");

        String recipient;
        String message;

        do {
            System.out.print("\nEnter recipient (or 'quit' to exit): ");
            recipient = scanner.nextLine();

            if (!recipient.equalsIgnoreCase("quit")) {
                System.out.print("Enter message: ");
                message = scanner.nextLine();

                try {
                    System.out.println("\n1. Sending via Email Adapter:");
                    emailAdapter.send(message, recipient);

                    System.out.println("\n2. Sending via SMS Service:");
                    smsSender.send(message, recipient);

                } catch (IllegalArgumentException e) {
                    System.out.println("Error: " + e.getMessage());
                } catch (Exception e) {
                    System.out.println("System error: " + e.getMessage());
                }
            }

        } while (!recipient.equalsIgnoreCase("quit"));

        scanner.close();
        System.out.println("Message demo completed.");
    }
}