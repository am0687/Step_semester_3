public class LibraryIsbnValidator {

    public static void main(String[] args) {
        String[] testCases = {
            " pen2026004251 ", // Valid after trimming
            "12N2026004251",   // Invalid: starts with digits
            "mcm20",           // Invalid: wrong length
            "mcm202600425A"    // Invalid: non-digit body
        };

        for (String raw : testCases) {
            String normalized = normalizeCode(raw);
            System.out.println("Input: \"" + raw + "\" -> " + validateAndFormat(normalized));
        }
    }

    /**
     * Trims spaces and uppercases only the first 3 characters of the code.
     */
    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        
        String trimmed = raw.trim();
        
        // Guard clause in case a string shorter than 3 characters is passed
        if (trimmed.length() < 3) {
            return trimmed.toUpperCase();
        }
        
        // Uppercase the first 3 characters and concatenate with the untouched remainder
        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String rest = trimmed.substring(3);
        
        return pubCode + rest;
    }

    /**
     * Validates the 13-character structure and formats the output.
     */
    public static String validateAndFormat(String code) {
        // Stage 1: Validate Exact Length
        if (code.length() != 13) {
            return "Invalid: wrong length (must be exactly 13 characters)";
        }

        // Stage 2: Validate Publisher Code (First 3 characters must be letters)
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        // Stage 3: Validate Year & Catalog Body (Remaining 10 characters must be digits)
        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        // Stage 4: Formatting with StringBuilder
        StringBuilder formattedDisplay = new StringBuilder();
        
        // Format: [PUBCODE] YEAR: 20XX | CATALOG: 123456
        formattedDisplay.append("[")
                        .append(code.substring(0, 3))
                        .append("] YEAR: ")
                        .append(code.substring(3, 7))    // 4-digit Year
                        .append(" | CATALOG: ")
                        .append(code.substring(7));      // Remaining 6 digits
                        
        return formattedDisplay.toString();
    }
}