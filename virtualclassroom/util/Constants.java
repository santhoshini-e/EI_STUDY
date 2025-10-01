package virtualclassroom.util;

public class Constants {
    public static final String WELCOME_MESSAGE =
            "=== Virtual Classroom Manager ===\n" +
                    "Available Commands:\n" +
                    "1. add_classroom <class_name>                    - Create a new classroom\n" +
                    "2. add_student <student_id> <class_name>         - Enroll student in class\n" +
                    "3. schedule_assignment <class_name> <details>    - Schedule assignment\n" +
                    "4. submit_assignment <student_id> <class_name> <details> - Submit assignment\n" +
                    "5. list_classrooms                               - List all classrooms\n" +
                    "6. list_students <class_name>                    - List students in class\n" +
                    "7. list_assignments <class_name>                 - List assignments for class\n" +
                    "8. help                                          - Show commands\n" +
                    "9. exit                                          - Quit application\n" +
                    "\nType your command:";
}