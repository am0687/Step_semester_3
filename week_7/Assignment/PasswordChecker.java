public class PasswordChecker {
    // Password is private and final, meaning it cannot be read or changed from outside
    private final String password;

    // Constructor sets the password once upon creation
    public PasswordChecker(String password) {
        // Fallback to empty string if null is provided, preventing NullPointerException
        this.password = (password != null) ? password : "";
    }

    // Returns the strength rating based on the length of the private password
    public String getStrength() {
        int length = this.password.length();

        if (length < 6) {
            return "Weak";
        } else if (length < 10) {
            return "Medium";
        } else {
            return "Strong";
        }
    }

    // Main method to demonstrate the expected behavior
    public static void main(String[] args) {
        PasswordChecker pc1 = new PasswordChecker("abcd");
        System.out.println("Strength of 'abcd': " + pc1.getStrength()); // "Weak"

        PasswordChecker pc2 = new PasswordChecker("abcdefgh");
        System.out.println("Strength of 'abcdefgh': " + pc2.getStrength()); // "Medium"

        PasswordChecker pc3 = new PasswordChecker("abcdefghij");
        System.out.println("Strength of 'abcdefghij': " + pc3.getStrength()); // "Strong"
        
        // Note: There is no way to do pc1.getPassword() - the data remains strictly internal!
    }
}