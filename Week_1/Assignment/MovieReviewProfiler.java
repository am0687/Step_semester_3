public class MovieReviewProfiler {

    public static void main(String[] args) {
        classifyWordLengths("This movie was absolutely fantastic and thrilling");
    }

    /**
     * Splits a review into words, categorizes them by length, and prints the profile.
     */
    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        // Split the string by one or more whitespace characters
        String[] words = review.trim().split("\\s+");

        for (String word : words) {
            // Optional but recommended: strip basic punctuation to count only true letters
            String cleanWord = word.replaceAll("[^a-zA-Z]", "");
            int length = cleanWord.length();

            if (length >= 1 && length <= 4) {
                shortCount++;
            } else if (length >= 5 && length <= 8) {
                mediumCount++;
            } else if (length >= 9) {
                longCount++;
            }
        }

        System.out.printf("Short: %d | Medium: %d | Long: %d\n", shortCount, mediumCount, longCount);
    }
}