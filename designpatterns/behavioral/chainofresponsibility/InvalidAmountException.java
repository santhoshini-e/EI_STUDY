package designpatterns.behavioral.chainofresponsibility;

/**
 * Custom exception for invalid amount scenarios
 */
public class InvalidAmountException extends RuntimeException {

    public InvalidAmountException(String message) {
        super(message);
    }
}