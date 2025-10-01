package virtualclassroom.model;

import java.time.LocalDateTime;

public class Assignment {
    private final String classroomName;
    private final String details;
    private final LocalDateTime scheduledDate;

    public Assignment(String classroomName, String details) {
        this.classroomName = classroomName;
        this.details = details;
        this.scheduledDate = LocalDateTime.now();
    }

    public String getClassroomName() { return classroomName; }
    public String getDetails() { return details; }
    public LocalDateTime getScheduledDate() { return scheduledDate; }

    public String getKey() {
        return classroomName + ":" + details;
    }
}