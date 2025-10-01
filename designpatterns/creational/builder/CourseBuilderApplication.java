package designpatterns.creational.builder;

import java.util.Scanner;

public class CourseBuilderApplication {
    public static void main(String[] args) {
        CourseManager manager = new CourseManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===Course Builder System===");
        boolean build = true;
        while (build) {
            System.out.print("\nCreate a course? (y/n): ");
            String response = scanner.nextLine().trim();
            if (!response.equalsIgnoreCase("y") && !response.equalsIgnoreCase("yes")) {
                build = false;
                continue;
            }
            manager.createCourse();
        }

        manager.listCourses();
        System.out.println("Thank you!");
        System.out.println("INFO : Application closed.");
        scanner.close();
    }
}