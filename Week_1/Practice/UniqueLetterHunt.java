import java.util.HashMap;
import java.util.Map;

public class UniqueLetterHunt {

    public static void main(String[] args) {
        String[] testCases = {"swiss", "aabbcc"};

        for (String text : testCases) {
            char result = findFirstNonRepeatingChar(text);
            
            if (result != '\0') {
                System.out.println("\"" + text + "\" -> First Non-Repeating Character: '" + result + "'");
            } else {
                System.out.println("\"" + text + "\" -> No Non-Repeating Character Found");
            }
        }
    }

    /**
     * Finds the first character in a string that appears exactly once.
     * Returns the null character '\0' if all characters repeat.
     */
    public static char findFirstNonRepeatingChar(String text) {
        Map<Character, Integer> frequencyMap = new HashMap<>();
        
        // Pass 1: Compute the frequency of every character
        for (char c : text.toCharArray()) {
            frequencyMap.put(c, frequencyMap.getOrDefault(c, 0) + 1);
        }
        
        // Pass 2: Scan left to right and return the first character with a count of 1
        for (char c : text.toCharArray()) {
            if (frequencyMap.get(c) == 1) {
                return c; // Early exit scanning
            }
        }
        
        // Return a default indicator if no non-repeating character is found
        return '\0';
    }
}