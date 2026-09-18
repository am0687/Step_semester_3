class PayrollAccount {
    // Private fields enforce strict encapsulation
    private double basicSalary;
    private double bonus;

    /**
     * Constructor sets the initial salary, with a safeguard against negative starting values.
     */
    public PayrollAccount(double basicSalary) {
        if (basicSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Starting at 0.0");
            this.basicSalary = 0.0;
        } else {
            this.basicSalary = basicSalary;
        }
        this.bonus = 0.0; // Initialized to zero by default
    }

    /**
     * Credits a bonus to the account, enforcing a strict positive-value rule.
     */
    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Bonus rejected: amount must be greater than zero.");
        } else {
            this.bonus += amount;
            System.out.println("Bonus credited: Rs " + amount);
        }
    }

    /**
     * Deducts tax as a percentage from the basic salary, validating the percentage range.
     */
    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Tax rejected: percentage must be between 0 and 100.");
        } else {
            double deduction = this.basicSalary * (percent / 100.0);
            this.basicSalary -= deduction;
            
            // Cast to int for clean formatting if it's a whole number, to match the sample output
            System.out.println("Tax deducted: " + (int) percent + "%");
        }
    }

    /**
     * Computed getter method for read-only access to the final derived value.
     */
    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class PayrollManager {

    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        
        account.creditBonus(5000);
        account.deductTax(10); // 10% tax on 50000 is 5000. Basic becomes 45000.
        
        System.out.println("Net salary: Rs " + account.getNetSalary()); // 45000 + 5000 = 50000
    }
}