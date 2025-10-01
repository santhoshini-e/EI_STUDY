package designpatterns.creational.builder;

/**
 * Represents an online course with configurable components.
 */
public class Course {
    private final String title;
    private final String instructor;
    private final String duration;
    private final Integer assignmentCount;
    private final Boolean certificateAvailable;

    private Course(Builder builder) {
        this.title = builder.title;
        this.instructor = builder.instructor;
        this.duration = builder.duration;
        this.assignmentCount = builder.assignmentCount;
        this.certificateAvailable = builder.certificateAvailable;
    }

    public String getTitle() { return title; }
    public String getInstructor() { return instructor; }
    public String getDuration() { return duration; }
    public Integer getAssignmentCount() { return assignmentCount; }
    public Boolean isCertificateAvailable() { return certificateAvailable; }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(title).append("\n");
        sb.append("Instructor: ").append(instructor).append("\n");
        if (duration != null) sb.append("Duration: ").append(duration).append("\n");
        if (assignmentCount != null) sb.append("Assignments: ").append(assignmentCount).append("\n");
        if (certificateAvailable != null) sb.append("Certificate: ").append(certificateAvailable ? "Yes" : "No").append("\n");
        return sb.toString();
    }

    public static class Builder {
        private final String title;
        private final String instructor;
        private String duration;
        private Integer assignmentCount;
        private Boolean certificateAvailable;

        public Builder(String title, String instructor) {
            if (title == null || title.trim().isEmpty())
                throw new IllegalArgumentException("Course title is required");
            if (instructor == null || instructor.trim().isEmpty())
                throw new IllegalArgumentException("Instructor name is required");

            this.title = title.trim();
            this.instructor = instructor.trim();
        }

        public Builder withDuration(String duration) {
            this.duration = duration;
            return this;
        }

        public Builder withAssignmentCount(Integer assignmentCount) {
            if (assignmentCount != null && assignmentCount < 0)
                throw new IllegalArgumentException("Assignment count cannot be negative");
            this.assignmentCount = assignmentCount;
            return this;
        }

        public Builder withCertificateAvailable(Boolean certificateAvailable) {
            this.certificateAvailable = certificateAvailable;
            return this;
        }

        public Course build() {
            return new Course(this);
        }
    }
}