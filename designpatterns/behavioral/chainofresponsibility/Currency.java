package designpatterns.behavioral.chainofresponsibility;

/**
 * Represents currency with amount and denomination breakdown
 */
public class Currency {
    private int amount;

    public Currency(int amount) {
        this.amount = amount;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}