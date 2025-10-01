package designpatterns.creational.singleton;

/**
 * Simple Logger implementation using Singleton design pattern.
 * Thread-safe implementation with lazy initialization.
 */
public class Logger {

    // Private static variable to hold the single instance
    private static Logger instance;

    // Private constructor to prevent external instantiation
    private Logger() {
        System.out.println("Logger instance created");
    }

    /**
     * Public method to provide global access to the singleton instance.
     * Uses synchronized method for thread safety.
     */
    public static synchronized Logger getInstance() {
        if (instance == null) {
            instance = new Logger();
        }
        return instance;
    }

    /**
     * Logs a message with timestamp.
     */

    public void log(String message) {
        System.out.println(java.time.LocalDateTime.now() + " : " + message);
    }
}