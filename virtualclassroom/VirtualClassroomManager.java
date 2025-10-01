package virtualclassroom;

import virtualclassroom.service.ClassroomManager;
import virtualclassroom.service.CommandService;
import virtualclassroom.util.Constants;
import virtualclassroom.util.Logger;

import java.util.Scanner;

public class VirtualClassroomManager {
    public static void main(String[] args) {
        Logger.info("Starting Virtual Classroom Manager");

        ClassroomManager manager = new ClassroomManager();
        CommandService commandService = new CommandService(manager);
        Scanner scanner = new Scanner(System.in);

        try {
            // Display welcome message and commands
            System.out.println(Constants.WELCOME_MESSAGE);

            // Main application loop
            while (commandService.isRunning()) {
                System.out.print("\n> ");
                String input = scanner.nextLine().trim();

                if (!input.isEmpty()) {
                    String result = commandService.executeCommand(input);
                    System.out.println(result);
                }
            }

        } catch (Exception e) {
            System.err.println("Fatal error: " + e.getMessage());
            Logger.error("Fatal error in application: " + e.getMessage());
        } finally {
            scanner.close();
        }
    }
}