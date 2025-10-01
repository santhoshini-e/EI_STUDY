package designpatterns.structural.bridge;

import java.util.Scanner;

/**
 * Demonstration class for the Bridge pattern in remote control system.
 */
public class RemoteControlDemo {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=== Remote Control System Demo ===");

        // Create devices
        Device television = new Television();
        Device radio = new Radio();

        // Create remotes
        RemoteControl basicTvRemote = new BasicRemote(television);
        RemoteControl advancedTvRemote = new AdvancedRemote(television);
        RemoteControl basicRadioRemote = new BasicRemote(radio);
        RemoteControl advancedRadioRemote = new AdvancedRemote(radio);

        RemoteControl currentRemote = null;
        String userChoice;

        do {
            displayMainMenu();
            System.out.print("Enter your choice: ");
            userChoice = scanner.nextLine();

            switch (userChoice) {
                case "1":
                    currentRemote = basicTvRemote;
                    System.out.println("Basic TV Remote selected");
                    break;
                case "2":
                    currentRemote = advancedTvRemote;
                    System.out.println("Advanced TV Remote selected");
                    break;
                case "3":
                    currentRemote = basicRadioRemote;
                    System.out.println("Basic Radio Remote selected");
                    break;
                case "4":
                    currentRemote = advancedRadioRemote;
                    System.out.println("Advanced Radio Remote selected");
                    break;
                case "5":
                    System.out.println("Exiting application...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
                    continue;
            }

            if (currentRemote != null && !userChoice.equals("5")) {
                operateRemote(currentRemote, scanner);
            }

        } while (!userChoice.equals("5"));

        scanner.close();
        System.out.println("Demo completed successfully.");
    }

    private static void displayMainMenu() {
        System.out.println("\n=== Main Menu ===");
        System.out.println("1. Use Basic TV Remote");
        System.out.println("2. Use Advanced TV Remote");
        System.out.println("3. Use Basic Radio Remote");
        System.out.println("4. Use Advanced Radio Remote");
        System.out.println("5. Exit");
    }

    private static void operateRemote(RemoteControl remote, Scanner scanner) {
        String operationChoice;

        do {
            displayRemoteOperations(remote);
            System.out.print("Enter operation choice: ");
            operationChoice = scanner.nextLine();

            switch (operationChoice) {
                case "1":
                    remote.togglePower();
                    break;
                case "2":
                    remote.volumeUp();
                    break;
                case "3":
                    remote.volumeDown();
                    break;
                case "4":
                    remote.displayStatus();
                    break;
                case "5":
                    if (remote instanceof AdvancedRemote) {
                        ((AdvancedRemote) remote).mute();
                    } else {
                        System.out.println("This feature is only available in Advanced Remote");
                    }
                    break;
                case "6":
                    if (remote instanceof AdvancedRemote) {
                        System.out.print("Enter volume level (0-100): ");
                        String volumeInput = scanner.nextLine();
                        try {
                            int volume = Integer.parseInt(volumeInput);
                            ((AdvancedRemote) remote).setSpecificVolume(volume);
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid volume input. Please enter a number.");
                        }
                    } else {
                        System.out.println("This feature is only available in Advanced Remote");
                    }
                    break;
                case "0":
                    System.out.println("Returning to main menu...");
                    break;
                default:
                    System.out.println("Invalid operation choice. Please try again.");
            }

        } while (!operationChoice.equals("0"));
    }

    private static void displayRemoteOperations(RemoteControl remote) {
        System.out.println("\n=== Remote Operations ===");
        System.out.println("1. Toggle Power");
        System.out.println("2. Volume Up");
        System.out.println("3. Volume Down");
        System.out.println("4. Display Status");

        if (remote instanceof AdvancedRemote) {
            System.out.println("5. Mute");
            System.out.println("6. Set Specific Volume");
        }

        System.out.println("0. Back to Main Menu");
    }
}