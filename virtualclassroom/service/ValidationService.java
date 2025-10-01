package virtualclassroom.service;

public class ValidationService {

    public static void validateClassName(String className) {
        if (className == null || className.trim().isEmpty()) {
            throw new IllegalArgumentException("Classroom name cannot be empty");
        }
        if (className.length() > 50) {
            throw new IllegalArgumentException("Classroom name too long (max 50 chars)");
        }
        if (!className.matches("^[a-zA-Z0-9\\s_-]+$")) {
            throw new IllegalArgumentException("Classroom name can only contain letters, numbers, spaces, hyphens and underscores");
        }
    }

    public static void validateStudentId(String studentId) {
        if (studentId == null || studentId.trim().isEmpty()) {
            throw new IllegalArgumentException("Student ID cannot be empty");
        }
        if (!studentId.matches("^[A-Za-z0-9_-]+$")) {
            throw new IllegalArgumentException("Student ID can only contain letters, numbers, hyphens and underscores");
        }
    }

    public static void validateAssignmentDetails(String details) {
        if (details == null || details.trim().isEmpty()) {
            throw new IllegalArgumentException("Assignment details cannot be empty");
        }
        if (details.length() > 200) {
            throw new IllegalArgumentException("Assignment details too long (max 200 chars)");
        }
    }

    public static void validateCommandParts(String[] parts, int minLength) {
        if (parts.length < minLength) {
            throw new IllegalArgumentException("Invalid command format. Expected at least " + minLength + " parts");
        }
    }
}