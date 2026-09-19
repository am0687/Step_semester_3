class Locker {
    // The physical locker number is fixed permanently at creation
    private final int lockerNumber;
    
    // The combination code is strictly private with NO getter method
    private String combinationCode;

    /**
     * Constructor initializes the locker number and the starting combination.
     */
    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    /**
     * Authenticates the user before allowing the combination to change.
     */
    public void changeCode(String currentCode, String newCode) {
        // Use .equals() to securely verify the string contents match
        if (this.combinationCode.equals(currentCode)) {
            this.combinationCode = newCode;
            System.out.println("success");
        } else {
            System.out.println("rejected, code remains unchanged");
        }
    }

    /**
     * Read-only getter for the locker number.
     * Note: There is deliberately NO getCombinationCode() method.
     */
    public int getLockerNumber() {
        return this.lockerNumber;
    }
}

public class GymApp {

    public static void main(String[] args) {
        // Initialize locker 101 with a default code
        Locker l = new Locker(101, "1234");
        
        // Attempt to change the code using the correct current password
        l.changeCode("1234", "5678");
        
        // Attempt to change the code using an incorrect password
        l.changeCode("0000", "9999");
    }
}