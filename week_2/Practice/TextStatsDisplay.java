public class TextStatsDisplay {

    public static void main(String[] args) {
        countVowelsAndConsonants("Java Programming");
    }

    /**
     * Counts and prints the number of vowels and consonants in a given string.
     */
    public static void countVowelsAndConsonants(String text) {
        int vowels = 0;
        int consonants = 0;

        // Convert the entire string to lowercase once to simplify character comparison
        String lowerText = text.toLowerCase();

        for (int i = 0; i < lowerText.length(); i++) {
            char c = lowerText.charAt(i);

            // Ignore spaces and any non-alphabetical characters
            if (c >= 'a' && c <= 'z') {
                // Check if the character is a vowel
                if (c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') {
                    vowels++;
                } else {
                    // If it is a letter but not a vowel, it must be a consonant
                    consonants++;
                }
            }
        }

        System.out.printf("Vowels: %d | Consonants: %d\n", vowels, consonants);
    }
}