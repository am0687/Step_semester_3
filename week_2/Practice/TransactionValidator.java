public class TransactionValidator {

    public static void main(String[] args) {
        String[] testCases = {
            " hdf03022600042 ", // Valid after trimming
            "12F03022600042",   // Invalid: starts with digits
            "sbi0101",          // Invalid: wrong length
            "sbi010A2600042"    // Invalid: non-digit body
        };

        for (String raw : testCases) {
            String normalized = normalizeReference(raw);
            System.out.println("Input: \"" + raw + "\" -> " + validateAndFormat(normalized));
        }
    }

    /**
     * Trims spaces and uppercases only the first 3 characters of the reference.
     */
    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        
        String trimmed = raw.trim();
        
        // Guard clause in case a severely truncated string is passed
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // Uppercase the first 3 characters and concatenate with the untouched remainder
        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        
        return bankCode + rest;
    }

    /**
     * Validates the 14-character structure without RegEx and formats the output.
     */
    public static String validateAndFormat(String reference) {
        // Stage 1: Validate Exact Length
        if (reference.length() != 14) {
            return "Invalid: wrong length (must be exactly 14 characters)";
        }

        // Stage 2: Validate Bank Code (First 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        // Stage 3: Validate Date & Sequence Body (Remaining 11 characters must be digits)
        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Stage 4: Formatting with StringBuilder
        StringBuilder formattedDisplay = new StringBuilder();
        
        // Format: [BANKCODE] DATE: dd/MM/yy | SEQ: 12345
        formattedDisplay.append("[")
                        .append(reference.substring(0, 3))
                        .append("] DATE: ")
                        .append(reference.substring(3, 5)) // dd
                        .append("/")
                        .append(reference.substring(5, 7)) // MM
                        .append("/")
                        .append(reference.substring(7, 9)) // yy
                        .append(" | SEQ: ")
                        .append(reference.substring(9));   // Remaining 5 digits
                        
        return formattedDisplay.toString();
    }
}