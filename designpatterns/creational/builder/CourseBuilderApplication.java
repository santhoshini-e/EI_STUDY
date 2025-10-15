package designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CourseBuilderApplication {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Course> courses = new ArrayList<>();

        System.out.println("=== Course Builder System ===");

        while (true) {
            System.out.print("\nCreate a course? (y/n): ");
            String input = scanner.nextLine().trim();
            if (!input.equalsIgnoreCase("y") && !input.equalsIgnoreCase("yes")) break;

            // Required fields
            System.out.print("Enter course title: ");
            String title = scanner.nextLine().trim();
            if (title.isEmpty()) {
                System.out.println("ERROR: Course title is required");
                continue;
            }

            System.out.print("Enter instructor name: ");
            String instructor = scanner.nextLine().trim();
            if (instructor.isEmpty()) {
                System.out.println("ERROR: Instructor name is required");
                continue;
            }

            Course.Builder builder = new Course.Builder(title, instructor);

            // Optional fields
            System.out.print("Enter course duration (optional): ");
            String duration = scanner.nextLine().trim();
            if (!duration.isEmpty()) builder.withDuration(duration);

            System.out.print("Include certificate? (yes/no/optional): ");
            String certInput = scanner.nextLine().trim();
            if (!certInput.isEmpty()) {
                builder.withCertificateAvailable(certInput.equalsIgnoreCase("yes")
                        || certInput.equalsIgnoreCase("y"));
            }

            courses.add(builder.build());
            System.out.println("\nSUCCESS: Course created!\n");
        }

        // List all courses
        if (courses.isEmpty()) {
            System.out.println("\nNo courses available.");
        } else {
            System.out.println("\n=== All Courses ===");
            for (int i = 0; i < courses.size(); i++) {
                System.out.println("Course " + (i + 1) + ":\n" + courses.get(i));
            }
        }

        System.out.println("Thank you! Application closed.");
        scanner.close();
    }
}