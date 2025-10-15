package virtualclassroom.service;

import virtualclassroom.util.Logger;
import virtualclassroom.model.Assignment;
import virtualclassroom.model.Classroom;
import virtualclassroom.model.Student;

import java.util.*;

public class ClassroomManager {
    private final Map<String, Classroom> classrooms = new HashMap<>();
    private final Map<String, Student> students = new HashMap<>();
    private boolean running = true;

    public String addClassroom(String className) {
        ValidationService.validateClassName(className);

        if (classrooms.containsKey(className)) {
            throw new IllegalArgumentException("Classroom '" + className + "' already exists");
        }

        classrooms.put(className, new Classroom(className));
        Logger.info("Classroom created: " + className);
        return "Classroom " + className + " has been created.";
    }

    public String addStudent(String studentId, String className) {
        ValidationService.validateStudentId(studentId);
        ValidationService.validateClassName(className);

        if (!classrooms.containsKey(className)) {
            throw new IllegalArgumentException("Classroom '" + className + "' not found");
        }

        Student student = students.get(studentId);
        if (student == null) {
            student = new Student(studentId);
            students.put(studentId, student);
        }

        Classroom classroom = classrooms.get(className);

        if (student.enrollInClassroom(className)) {
            classroom.addStudent(studentId);
            Logger.info("Student enrolled: " + studentId + " in " + className);
            return "Student " + studentId + " has been enrolled in " + className + ".";
        }
        return "Student " + studentId + " is already enrolled in " + className + ".";

    }

    public String scheduleAssignment(String className, String assignmentId) {
        ValidationService.validateClassName(className);
        ValidationService.validateAssignment(assignmentId);

        if (!classrooms.containsKey(className)) {
            throw new IllegalArgumentException("Classroom '" + className + "' not found");
        }

        Classroom classroom = classrooms.get(className);

        if (classroom.addAssignment(assignmentId)) {
            Assignment assignment = new Assignment(className, assignmentId);
            Logger.info("Assignment scheduled for " + className + ": " + assignmentId);
            return "Assignment for " + className + " has been scheduled.";
        }
        return "Assignment for " + className + " has already been scheduled.";
    }

    public String submitAssignment(String studentId, String className, String assignmentId) {
        ValidationService.validateStudentId(studentId);
        ValidationService.validateClassName(className);
        ValidationService.validateAssignment(assignmentId);

        Student student = students.get(studentId);
        if (student == null) {
            throw new IllegalArgumentException("Student '" + studentId + "' not found");
        }

        if (!classrooms.containsKey(className)) {
            throw new IllegalArgumentException("Classroom '" + className + "' not found");
        }

        if (!student.isEnrolledIn(className)) {
            throw new IllegalArgumentException("Student '" + studentId + "' is not enrolled in '" + className + "'");
        }

        // Check if assignment exists in the classroom
        Classroom classroom = classrooms.get(className);
        if (!classroom.getAssignmentIds().contains(assignmentId)) {
            throw new IllegalArgumentException("Assignment '" + assignmentId + "' does not exist in classroom '" + className + "'");
        }

        String assignmentKey = className + ":" + assignmentId;
        if (student.submitAssignment(assignmentKey)) {
            Logger.info("Assignment submitted by " + studentId + " in " + className + ": " + assignmentId);
            return "Assignment submitted by Student " + studentId + " in " + className + ".";
        } else {
            return "Assignment already submitted by Student " + studentId + " in " + className + ".";
        }
    }

    public String listClassrooms() {
        if (classrooms.isEmpty()) {
            return "No classrooms available.";
        }

        StringBuilder sb = new StringBuilder("Classrooms:\n");
        for (Classroom classroom : classrooms.values()) {
            sb.append("  - ")
                    .append(classroom.getName())
                    .append(" (Students: ").append(classroom.getStudentIds().size())
                    .append(", Assignments: ").append(classroom.getAssignmentIds().size())
                    .append(")\n");
        }
        return sb.toString();
    }

    public String listStudents(String className) {
        ValidationService.validateClassName(className);

        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + className + "' not found");
        }

        Set<String> studentIds = classroom.getStudentIds();
        if (studentIds.isEmpty()) {
            return "No students enrolled in " + className + ".";
        }

        StringBuilder sb = new StringBuilder("Students in " + className + ":\n");
        for (String studentId : studentIds) {
            sb.append("  - ").append(studentId).append("\n");
        }
        return sb.toString();
    }

    public String listAssignments(String className) {
        ValidationService.validateClassName(className);

        Classroom classroom = classrooms.get(className);
        if (classroom == null) {
            throw new IllegalArgumentException("Classroom '" + className + "' not found");
        }

        Set<String> assignmentIds = classroom.getAssignmentIds();
        if (assignmentIds.isEmpty()) {
            return "No assignments for " + className + ".";
        }

        StringBuilder sb = new StringBuilder("Assignments for " + className + ":\n");
        for (String assignment : assignmentIds) {
            sb.append("  - ").append(assignment).append("\n");
        }
        return sb.toString();
    }

    public void stop() {
        this.running = false;
        Logger.info("Application stopped");
    }

    public boolean isRunning() {
        return running;
    }
}