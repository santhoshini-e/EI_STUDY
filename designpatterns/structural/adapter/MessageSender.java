package designpatterns.structural.adapter;

/**
 * Target interface that clients expect to work with.
 */
public interface MessageSender {
    void send(String message, String recipient);
}