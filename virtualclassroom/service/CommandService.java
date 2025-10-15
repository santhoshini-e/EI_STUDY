package virtualclassroom.service;

import virtualclassroom.util.Constants;
import virtualclassroom.util.Logger;

public class CommandService {
    private final ClassroomManager manager;

    public CommandService(ClassroomManager manager) {
        this.manager = manager;
    }

    public String executeCommand(String input) {
        try {
            String[] parts = input.trim().split("\\s+");
            String command = parts[0].toLowerCase();

            switch (command) {
                case "add_classroom":
                    ValidationService.validateCommandParts(parts, 2);
                    return manager.addClassroom(parts[1]);

                case "add_student":
                    ValidationService.validateCommandParts(parts, 3);
                    return manager.addStudent(parts[1], parts[2]);

                case "schedule_assignment":
                    ValidationService.validateCommandParts(parts, 3);
                    String assignmentDetails = parts.length > 3 ? parts[2] + " " + parts[3] : parts[2];
                    return manager.scheduleAssignment(parts[1], assignmentDetails);

                case "submit_assignment":
                    ValidationService.validateCommandParts(parts, 4);
                    return manager.submitAssignment(parts[1], parts[2], parts[3]);

                case "list_classrooms":
                    return manager.listClassrooms();

                case "list_students":
                    ValidationService.validateCommandParts(parts, 2);
                    return manager.listStudents(parts[1]);

                case "list_assignments":
                    ValidationService.validateCommandParts(parts, 2);
                    return manager.listAssignments(parts[1]);

                case "help":
                    return getHelpMessage();

                case "exit":
                    manager.stop();
                    return "Thank you for using Virtual Classroom.";

                default:
                    return "Error: Unknown command '" + command + "'. Type 'help' for available commands.";
            }

        } catch (IllegalArgumentException e) {
            Logger.warn("Validation error for input '" + input + "': " + e.getMessage());
            return "Error: " + e.getMessage();
        } catch (Exception e) {
            Logger.error("Unexpected error processing command '" + input + "': " + e.getMessage());
            return "System error: " + e.getMessage();
        }
    }

    private String getHelpMessage() {
        return Constants.WELCOME_MESSAGE;
    }

    public boolean isRunning() {
        return manager.isRunning();
    }
}