package virtualclassroom.model;

public class Assignment {
    private final String classroomName;
    private final String assignmentId;

    public Assignment(String classroomName, String assignmentId) {
        this.classroomName = classroomName;
        this.assignmentId = assignmentId;
    }

    public String getClassroomName() {
        return classroomName;
    }

    public String getAssignmentId() {
        return assignmentId;
    }
}