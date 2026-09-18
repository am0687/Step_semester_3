public class PalindromeChecker {

    public static void main(String[] args) {
        String[] testCases = {"madam", "hello"};

        for (String text : testCases) {
            boolean iterResult = isPalindromeIterative(text);
            boolean recResult = isPalindromeRecursive(text);
            boolean arrResult = isPalindromeArrayReversal(text);

            String iterText = iterResult ? "Palindrome" : "Not Palindrome";
            String recText = recResult ? "Palindrome" : "Not Palindrome";
            String arrText = arrResult ? "Palindrome" : "Not Palindrome";

            System.out.printf("\"%s\"\tIterative: %s | Recursive: %s | Array Reversal: %s\n",
                    text, iterText, recText, arrText);
        }
    }

    /**
     * Approach 1: Iterative
     * Compares characters from both ends moving toward the middle.
     */
    public static boolean isPalindromeIterative(String text) {
        int left = 0;
        int right = text.length() - 1;
        
        while (left < right) {
            if (text.charAt(left) != text.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    /**
     * Approach 2: Recursive
     * Recursively compares the first and last characters, shrinking the substring each call.
     */
    public static boolean isPalindromeRecursive(String text) {
        // Base case: strings of length 0 or 1 are inherently palindromes.
        if (text.length() <= 1) {
            return true;
        }
        
        // If the outer characters do not match, it is not a palindrome.
        if (text.charAt(0) != text.charAt(text.length() - 1)) {
            return false;
        }
        
        // Shrink the substring by removing the first and last characters.
        return isPalindromeRecursive(text.substring(1, text.length() - 1));
    }

    /**
     * Approach 3: Array Reversal
     * Converts the string to a character array, reverses it, and compares it to the original.
     */
    public static boolean isPalindromeArrayReversal(String text) {
        char[] original = text.toCharArray();
        char[] reversed = new char[original.length];
        
        // Populate the reversed array
        for (int i = 0; i < original.length; i++) {
            reversed[i] = original[original.length - 1 - i];
        }
        
        // Convert back to a String and compare
        return text.equals(new String(reversed));
    }
}