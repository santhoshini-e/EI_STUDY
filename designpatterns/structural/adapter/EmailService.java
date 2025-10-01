package designpatterns.structural.adapter;

/**
 * Adaptee class with incompatible interface.
 * This is the legacy system we need to adapt.
 */
public class EmailService {

    public void sendEmail(String toAddress, String subject, String body) {
        if (toAddress == null || toAddress.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient email address cannot be null or empty");
        }
        if (body == null || body.trim().isEmpty()) {
            throw new IllegalArgumentException("Email body cannot be null or empty");
        }

        System.out.println("Email Service:");
        System.out.println("To: " + toAddress);
        System.out.println("Subject: " + subject);
        System.out.println("Body: " + body);
        System.out.println("--- Email sent via email system ---");
    }
}