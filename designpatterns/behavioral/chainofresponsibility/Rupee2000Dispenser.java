package designpatterns.behavioral.chainofresponsibility;

/**
 * Handles ₹2000 denomination dispensing
 */
public class Rupee2000Dispenser implements DispenseChain {

    private static final int DENOMINATION = 2000;

    private DispenseChain chain;

    @Override
    public void setNextChain(DispenseChain nextChain) {
        this.chain = nextChain;
    }

    @Override
    public void dispense(Currency currency) {
        if (currency.getAmount() >= DENOMINATION) {
            int num = currency.getAmount() / DENOMINATION;
            int remainder = currency.getAmount() % DENOMINATION;

            System.out.println("ACTION : Dispensing " + num + " x INR " + DENOMINATION + " note");

            if (remainder != 0) {
                currency.setAmount(remainder);
                this.chain.dispense(currency);
            }
        } else {
            this.chain.dispense(currency);
        }
    }
}