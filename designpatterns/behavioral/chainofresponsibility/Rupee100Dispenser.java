package designpatterns.behavioral.chainofresponsibility;

/**
 * Handles ₹100 denomination dispensing - the final handler in chain
 */
public class Rupee100Dispenser implements DispenseChain {

    private static final int DENOMINATION = 100;

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
        } else if (currency.getAmount() > 0) {
            System.out.println("NOTE: INR " + currency.getAmount() + " cannot be dispensed with available denominations");
        }
    }
}