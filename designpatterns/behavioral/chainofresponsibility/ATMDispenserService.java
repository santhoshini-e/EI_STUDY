package designpatterns.behavioral.chainofresponsibility;

/**
 * Service class that sets up the chain and processes withdrawal requests
 */
public class ATMDispenserService {

    private static final int MIN_AMOUNT = 100;
    private static final int MAX_AMOUNT = 50000;

    private DispenseChain chain;

    public ATMDispenserService() {
        initializeChain();
    }

    /**
     * Initializes the chain of responsibility
     */
    private void initializeChain() {
        DispenseChain chain2000 = new Rupee2000Dispenser();
        DispenseChain chain500 = new Rupee500Dispenser();
        DispenseChain chain100 = new Rupee100Dispenser();

        chain2000.setNextChain(chain500);
        chain500.setNextChain(chain100);

        this.chain = chain2000;
    }

    /**
     * Processes withdrawal request with validation
     */
    public void withdraw(int amount) {

        validateAmount(amount);

        System.out.println("INFO : Processing withdrawal of INR " + amount);
        Currency currency = new Currency(amount);
        chain.dispense(currency);
        System.out.println("SUCCESS : Withdrawal processing complete");
    }

    /**
     * Validates the withdrawal amount
     */
    private void validateAmount(int amount) {
        if (amount <= 0) {
            String errorMsg = "Amount must be positive";
            throw new InvalidAmountException(errorMsg);
        }

        if (amount < MIN_AMOUNT) {
            String errorMsg = "Minimum withdrawal amount is " + MIN_AMOUNT;
            throw new InvalidAmountException(errorMsg);
        }

        if (amount > MAX_AMOUNT) {
            String errorMsg = "Maximum withdrawal amount is " + MAX_AMOUNT;
            throw new InvalidAmountException(errorMsg);
        }

        if (amount % 100 != 0) {
            String errorMsg = "Amount must be in multiples of 100";
            throw new InvalidAmountException(errorMsg);
        }
    }
}