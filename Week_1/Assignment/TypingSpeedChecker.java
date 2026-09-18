public class TypingSpeedChecker {

    public static void main(String[] args) {
        checkTypingAccuracy("hello world", "hello worlt");
        checkTypingAccuracy("coding", "coding");
    }

    /**
     * Compares two strings of equal length character by character, 
     * calculates accuracy, and identifies the first mismatch.
     */
    public static void checkTypingAccuracy(String original, String typed) {
        // Validate input lengths just in case
        if (original.length() != typed.length()) {
            System.out.println("Error: The original and typed strings must be of equal length.");
            return;
        }

        int totalCharacters = original.length();
        int matchedCharacters = 0;
        int firstMismatchIndex = -1;

        // Traverse both strings simultaneously
        for (int i = 0; i < totalCharacters; i++) {
            if (original.charAt(i) == typed.charAt(i)) {
                matchedCharacters++;
            } else if (firstMismatchIndex == -1) {
                // Record only the VERY FIRST mismatch using a sentinel flag check
                firstMismatchIndex = i;
            }
        }

        // Calculate percentage (requires casting to double to prevent integer truncation)
        double accuracy = ((double) matchedCharacters / totalCharacters) * 100;

        // Print results based on whether a mismatch was found
        if (firstMismatchIndex == -1) {
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | No Mismatches\n", 
                              matchedCharacters, totalCharacters, accuracy);
        } else {
            char expectedChar = original.charAt(firstMismatchIndex);
            char typedChar = typed.charAt(firstMismatchIndex);
            // Convert 0-based index to 1-based position for user-friendly output
            int position = firstMismatchIndex + 1;
            
            System.out.printf("Matched: %d/%d | Accuracy: %.2f%% | First Mismatch at position %d ('%c' vs '%c')\n", 
                              matchedCharacters, totalCharacters, accuracy, position, expectedChar, typedChar);
        }
    }
}