class PiggyBank {
    // The final keyword locks this variable permanently after initialization
    private final String id;
    
    // Private access modifier prevents direct external manipulation
    private double savings;

    /**
     * Constructor initializes the fixed ID and ensures savings start at 0.
     */
    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0.0;
    }

    /**
     * Safely adds funds to the piggy bank.
     */
    public void deposit(double amount) {
        if (amount <= 0) {
            System.out.println("Deposit rejected: amount must be greater than zero.");
        } else {
            this.savings += amount;
            System.out.println("Deposited: " + amount + " -> savings = " + this.savings);
        }
    }

    /**
     * Withdraws funds only if the requested amount does not exceed current savings.
     */
    public void withdraw(double amount) {
        if (amount > this.savings) {
            System.out.println("Withdrawal of " + amount + " rejected, savings stays " + this.savings);
        } else if (amount <= 0) {
            System.out.println("Withdrawal rejected: amount must be greater than zero.");
        } else {
            this.savings -= amount;
            System.out.println("Withdrew: " + amount + " -> savings = " + this.savings);
        }
    }

    /**
     * Read-only getter method allowing the app to view the current savings.
     */
    public double getSavings() {
        return this.savings;
    }

    /**
     * Read-only getter method for the Piggy Bank ID.
     */
    public String getId() {
        return this.id;
    }
}

public class SavingsApp {

    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}