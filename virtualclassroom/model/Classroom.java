package virtualclassroom.model;

import java.util.HashSet;
import java.util.Set;

public class Classroom {
    private final String name;
    private final Set<String> studentIds;
    private final Set<String> assignments;

    public Classroom(String name) {
        this.name = name;
        this.studentIds = new HashSet<>();
        this.assignments = new HashSet<>();
    }

    public String getName() { return name; }
    public Set<String> getStudentIds() { return studentIds; }
    public Set<String> getAssignments() { return assignments; }

    public boolean addStudent(String studentId) {
        return studentIds.add(studentId);
    }

    public boolean addAssignment(String assignment) {
        return assignments.add(assignment);
    }

    public boolean hasStudent(String studentId) {
        return studentIds.contains(studentId);
    }
}