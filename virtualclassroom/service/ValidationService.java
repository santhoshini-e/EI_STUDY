package virtualclassroom.service;

public class ValidationService {

    private static void validate(String value, String fieldName) {
        if (value == null || value.trim().isEmpty()) {
            throw new IllegalArgumentException(fieldName + " cannot be empty");
        }
    }

    public static void validateClassName(String className) {
        validate(className, "Classroom name");
    }

    public static void validateStudentId(String studentId) {
        validate(studentId, "Student ID");
    }

    public static void validateAssignment(String details) {
        validate(details, "Assignment ID");
    }


    public static void validateCommandParts(String[] parts, int minLength) {
        if (parts.length < minLength) {
            throw new IllegalArgumentException("Invalid command format. Expected at least " + minLength + " parts");
        }
    }
}