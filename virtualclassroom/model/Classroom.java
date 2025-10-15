package virtualclassroom.model;

import java.util.HashSet;
import java.util.Set;

public class Classroom {
    private final String name;
    private final Set<String> studentIds;
    private final Set<String> assignmentIds;

    public Classroom(String name) {
        this.name = name;
        this.studentIds = new HashSet<>();
        this.assignmentIds = new HashSet<>();
    }

    public String getName() { return name; }
    public Set<String> getStudentIds() { return studentIds; }
    public Set<String> getAssignmentIds() { return assignmentIds; }

    public boolean addStudent(String studentId) {
        return studentIds.add(studentId);
    }

    public boolean addAssignment(String assignment) {
        return assignmentIds.add(assignment);
    }
}