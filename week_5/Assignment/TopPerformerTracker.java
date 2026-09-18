public class TopPerformerTracker {

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        System.out.println(findMinMaxSpread(scores));
    }

    /**
     * Finds the minimum and maximum scores in a single pass and calculates the spread.
     */
    public static String findMinMaxSpread(int[] scores) {
        if (scores == null || scores.length == 0) {
            return "";
        }

        // Initialize both min and max to the first element's value
        int min = scores[0];
        int max = scores[0];

        // Start scanning from the second element
        for (int i = 1; i < scores.length; i++) {
            if (scores[i] < min) {
                min = scores[i];
            } else if (scores[i] > max) {
                max = scores[i];
            }
        }

        int spread = max - min;

        return String.format("Min: %d | Max: %d | Spread: %d", min, max, spread);
    }
}