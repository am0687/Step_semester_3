class MessWallet {
    // Private field ensures the balance cannot be modified directly from outside the class
    private double balance;

    /**
     * Constructor sets the initial state, with a safeguard against negative starting values.
     */
    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Starting at 0.0");
            this.balance = 0.0;
        } else {
            this.balance = openingBalance;
        }
    }

    /**
     * Adds funds to the wallet, enforcing a strict positive-value rule.
     */
    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than zero.");
        } else {
            this.balance += amount;
            System.out.println("Balance after top-up: " + this.balance);
        }
    }

    /**
     * Subtracts funds from the wallet, guaranteeing the balance never drops below zero.
     */
    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else if (amount <= 0) {
            System.out.println("Deduct rejected: amount must be greater than zero.");
        } else {
            this.balance -= amount;
        }
    }

    /**
     * Read-only getter method allowing external classes to view the balance.
     */
    public double getBalance() {
        return this.balance;
    }
}

public class WalletManagement {

    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        
        wallet.topUp(200);
        wallet.deduct(1000);
        
        System.out.println("Final balance: " + wallet.getBalance());
    }
}