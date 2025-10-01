package virtualclassroom.model;

import java.util.HashSet;
import java.util.Set;

public class Student {
    private final String id;
    private final Set<String> classroomNames;
    private final Set<String> submissions;

    public Student(String id) {
        this.id = id;
        this.classroomNames = new HashSet<>();
        this.submissions = new HashSet<>();
    }

    public String getId() { return id; }
    public Set<String> getClassroomNames() { return classroomNames; }
    public Set<String> getSubmissions() { return submissions; }

    public boolean enrollInClassroom(String classroomName) {
        return classroomNames.add(classroomName);
    }

    public boolean submitAssignment(String assignmentKey) {
        return submissions.add(assignmentKey);
    }

    public boolean isEnrolledIn(String classroomName) {
        return classroomNames.contains(classroomName);
    }
}