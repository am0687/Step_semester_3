public class AtmPinValidator {

    public static void main(String[] args) {
        checkPinLength("482");
        checkPinLength("4820");
    }

    /**
     * Checks if the entered PIN is exactly 4 characters long.
     */
    public static void checkPinLength(String pin) {
        // A null check is included to prevent NullPointerException
        if (pin != null && pin.length() == 4) {
            System.out.println("PIN length OK.");
        } else {
            System.out.println("Invalid PIN — must be exactly 4 digits.");
        }
    }
}