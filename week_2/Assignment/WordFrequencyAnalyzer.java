import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class WordFrequencyAnalyzer {

    public static void main(String[] args) {
        printFilteredWordFrequency("The mentor was great, the session was great and clear.");
    }

    /**
     * Cleans text, removes stop words, counts word frequencies, 
     * and prints them in descending order of frequency.
     */
    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.trim().isEmpty()) {
            return;
        }

        // Define the fixed list of stop words
        Set<String> stopWords = new HashSet<>(Arrays.asList(
            "the", "was", "and", "a", "is", "of", "in"
        ));

        // Normalize: convert to lowercase and strip basic punctuation using replace()
        String cleanedFeedback = feedback.toLowerCase()
                                         .replace(",", "")
                                         .replace(".", "");

        // Split the cleaned text into words using one or more whitespaces
        String[] words = cleanedFeedback.split("\\s+");

        // Count frequencies of meaningful words
        Map<String, Integer> frequencyMap = new HashMap<>();
        for (String word : words) {
            // Skip empty strings (possible from extra spaces) and stop words
            if (!word.isEmpty() && !stopWords.contains(word)) {
                frequencyMap.put(word, frequencyMap.getOrDefault(word, 0) + 1);
            }
        }

        // Convert the map entries to a List to enable sorting
        List<Map.Entry<String, Integer>> entryList = new ArrayList<>(frequencyMap.entrySet());

        // Sort the list by value (count) in descending order
        entryList.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Print the final sorted frequencies
        for (Map.Entry<String, Integer> entry : entryList) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }
}