package designpatterns.behavioral.chainofresponsibility;

/**
 * Chain of Responsibility interface for currency dispensers
 */
public interface DispenseChain {

    /**
     * Sets the next handler in the chain
     */
    void setNextChain(DispenseChain nextChain);

    /**
     * Dispenses currency and passes remaining amount to next handler
     */
    void dispense(Currency currency);
}