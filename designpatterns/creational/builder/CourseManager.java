package designpatterns.creational.builder;

import java.util.ArrayList;
import java.util.List;

public class CourseManager {
    private final List<Course> courses = new ArrayList<>();
    private final CourseInputHandler inputHandler = new CourseInputHandler();

    public void createCourse() {
        try {
            Course course = inputHandler.createCourse();
            courses.add(course);
            System.out.println("\nSUCCESS: Course created!");
            System.out.println(course);
        } catch (Exception e) {
            System.out.println("ERROR: " + e.getMessage());
        }
    }

    public void listCourses() {
        if (courses.isEmpty()) {
            System.out.println("\nNo courses available");
            return;
        }

        System.out.println("\n=== All Courses ===");
        for (int i = 0; i < courses.size(); i++) {
            System.out.println("Course " + (i + 1) + ":\n" + courses.get(i));
        }
    }
}