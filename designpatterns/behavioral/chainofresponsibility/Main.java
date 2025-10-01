package designpatterns.behavioral.chainofresponsibility;

import java.util.Scanner;

/**
 * Main class to demonstrate ATM Cash Withdrawal using Chain of Responsibility
 */
public class Main {


    public static void main(String[] args) {

        ATMDispenserService atmService = new ATMDispenserService();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to ATM Cash Dispenser System");
        System.out.println("=====================================");

        boolean continueProcessing = true;

        try {
            while (continueProcessing) {
                try {
                    System.out.print("Enter amount to withdraw (or -1 to exit): ");
                    int amount = scanner.nextInt();

                    if (amount == -1) {
                        continueProcessing = false;
                        System.out.println("Thank you for using ATM Service!");
                    } else {
                        atmService.withdraw(amount);
                    }

                } catch (InvalidAmountException e) {
                    System.out.println("Error: " + e.getMessage());
                    scanner.nextLine();
                } catch (Exception e) {
                    System.out.println("Unexpected error: " + e.getMessage());
                    scanner.nextLine(); // Clear buffer
                }
            }
        } finally {
            scanner.close();
        }
    }
}