package designpatterns.structural.adapter;

/**
 * Adapter class that adapts LegacyEmailService to MessageSender interface.
 */
public class EmailAdapter implements MessageSender {
    private EmailService emailService;

    public EmailAdapter() {
        this.emailService = new EmailService();
    }

    @Override
    public void send(String message, String recipient) {
        if (message == null || message.trim().isEmpty()) {
            throw new IllegalArgumentException("Message cannot be null or empty");
        }
        if (recipient == null || recipient.trim().isEmpty()) {
            throw new IllegalArgumentException("Recipient cannot be null or empty");
        }

        emailService.sendEmail(recipient, "Notification", message);
    }
}