package designpatterns.creational.builder;

import java.util.Scanner;

public class CourseInputHandler {
    private final Scanner scanner = new Scanner(System.in);

    public Course createCourse() {
        System.out.println("\n=== Create New Course ===");

        // Required fields
        System.out.print("Enter course title: ");
        String title = scanner.nextLine().trim();
        if (title.isEmpty()) throw new IllegalArgumentException("Course title is required");

        System.out.print("Enter instructor name: ");
        String instructor = scanner.nextLine().trim();
        if (instructor.isEmpty()) throw new IllegalArgumentException("Instructor name is required");

        Course.Builder builder = new Course.Builder(title, instructor);

        // Optional fields
        System.out.print("Enter course duration (optional): ");
        String duration = scanner.nextLine().trim();
        if (!duration.isEmpty()) builder.withDuration(duration);

        // Assignment input with retry loop
        Integer assignments = getAssignmentInput();
        if (assignments != null) builder.withAssignmentCount(assignments);

        System.out.print("Include certificate? (yes/no/optional): ");
        String certificateInput = scanner.nextLine().trim();
        if (!certificateInput.isEmpty()) {
            if (certificateInput.equalsIgnoreCase("yes") || certificateInput.equalsIgnoreCase("y")) {
                builder.withCertificateAvailable(true);
            } else if (certificateInput.equalsIgnoreCase("no") || certificateInput.equalsIgnoreCase("n")) {
                builder.withCertificateAvailable(false);
            }
        }

        return builder.build();
    }

    private Integer getAssignmentInput() {
        while (true) {
            System.out.print("Enter number of assignments (optional): ");
            String input = scanner.nextLine().trim();

            if (input.isEmpty()) {
                return null; // User chose to skip
            }

            try {
                int assignments = Integer.parseInt(input);
                if (assignments < 0) {
                    System.out.println("ERROR: Assignment count cannot be negative.");
                    continue;
                }
                return assignments;
            } catch (NumberFormatException e) {
                System.out.println("ERROR: Please enter a valid number.");
            }
        }
    }

    public void close() {
        scanner.close();
    }
}