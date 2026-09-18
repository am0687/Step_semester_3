public class WordReversalEncoder {

    public static void main(String[] args) {
        System.out.println(reverseEachWord("hello club"));
    }

    /**
     * Reverses each individual word in a sentence while maintaining word order.
     */
    public static String reverseEachWord(String sentence) {
        if (sentence == null || sentence.isEmpty()) {
            return "";
        }

        // Split the sentence into an array of individual words
        String[] words = sentence.split(" ");
        StringBuilder reversedSentence = new StringBuilder();

        for (int i = 0; i < words.length; i++) {
            // Use StringBuilder's built-in reverse() method for each word
            StringBuilder reversedWord = new StringBuilder(words[i]);
            reversedWord.reverse();

            // Append the reversed word to our final result
            reversedSentence.append(reversedWord);

            // Add a space after each word, avoiding a trailing space at the very end
            if (i < words.length - 1) {
                reversedSentence.append(" ");
            }
        }

        return reversedSentence.toString();
    }
}