public class PhoneNumberFormatter {

    public static void main(String[] args) {
        System.out.println(maskPhoneNumber("9876543210"));
        System.out.println(maskPhoneNumber("98765"));
        System.out.println(maskPhoneNumber("98765a3210")); // Test for non-numeric characters
    }

    /**
     * Validates a 10-digit phone number and returns a masked version.
     */
    public static String maskPhoneNumber(String phone) {
        // Validate length and ensure all characters are numeric digits
        if (phone == null || phone.length() != 10 || !phone.matches("\\d+")) {
            return "Invalid phone number";
        }

        // Initialize StringBuilder with the masking pattern
        StringBuilder maskedNumber = new StringBuilder("XXXXXX");
        
        // Extract the last 4 digits
        String lastFourDigits = phone.substring(6);
        maskedNumber.append(lastFourDigits);
        
        // Insert the hyphen exactly after the 6th 'X'
        maskedNumber.insert(6, "-");

        return maskedNumber.toString();
    }
}