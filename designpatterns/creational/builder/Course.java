package designpatterns.creational.builder;

/**
 * Represents an online course with configurable components.
 */
public class Course {
    private final String title;
    private final String instructor;
    private final String duration;
    private final Boolean certificateAvailable;

    private Course(Builder builder) {
        this.title = builder.title;
        this.instructor = builder.instructor;
        this.duration = builder.duration;
        this.certificateAvailable = builder.certificateAvailable;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Course: ").append(title).append("\n");
        sb.append("Instructor: ").append(instructor).append("\n");
        if (duration != null) sb.append("Duration: ").append(duration).append("\n");
        if (certificateAvailable != null)
            sb.append("Certificate: ").append(certificateAvailable ? "Yes" : "No").append("\n");
        return sb.toString();
    }

    public static class Builder {
        private final String title;
        private final String instructor;
        private String duration;
        private Boolean certificateAvailable;

        public Builder(String title, String instructor) {
            this.title = title.trim();
            this.instructor = instructor.trim();
        }

        public void withDuration(String duration) {
            this.duration = duration;
        }

        public void withCertificateAvailable(Boolean certificateAvailable) {
            this.certificateAvailable = certificateAvailable;
        }

        public Course build() {
            return new Course(this);
        }
    }
}