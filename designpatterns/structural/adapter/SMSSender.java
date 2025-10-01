package designpatterns.structural.adapter;

/**
 * Modern SMS service that already implements MessageSender interface.
 */
public class SMSSender implements MessageSender {

    @Override
    public void send(String message, String recipient) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("SMS message cannot be null or empty");
        }
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("SMS recipient cannot be null or empty");
        }

        System.out.println("SMS Service:");
        System.out.println("To: " + recipient);
        System.out.println("Message: " + message);
        System.out.println("--- SMS sent ---");
    }
}