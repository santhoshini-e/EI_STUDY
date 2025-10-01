package designpatterns.behavioral.observer;

import java.util.Scanner;

/**
 * Main application demonstrating Observer Pattern
 */
public class ScoreApp {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LiveScore liveScore = new LiveScore();

        System.out.println("=== Live Score Updates ===");
        // Score updates
        boolean running = true;
        showMenu();

        while (running) {
            System.out.print("\nEnter choice (1-6): ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            if (choice <= 0 || choice > 6) {
                System.out.print("Enter a valid choice.");
                continue;
            }

            switch (choice) {
                case 1: {
                    System.out.print("Enter user name : ");
                    String user = scanner.nextLine();
                    if (isBlank(user)) continue;
                    liveScore.addObserver(new MobileDisplay(user));
                    break;
                }

                case 2: {
                    System.out.print("Enter score update : ");
                    String score = scanner.nextLine();
                    liveScore.setScore(score);
                    break;
                }

                case 3: {
                    showMenu();
                    break;
                }

                case 4: {
                    running = false;
                    System.out.println("Thank you for using Live Score App.");
                    System.out.println("INFO : Application closed.");
                }
            }

        }
        scanner.close();
    }

    private static void showMenu() {
        System.out.print(
                "1. Add Observer \n2. Update Score \n3. Help \n4. Exit"
        );
    }

    private static boolean isBlank(String username) {
        if (username.isBlank()) {
            System.out.println("ERROR : User name cannot be Empty.");
            return true;
        }
        return false;
    }
}