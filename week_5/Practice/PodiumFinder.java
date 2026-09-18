public class PodiumFinder {

    public static void main(String[] args) {
        int[] scores = {45, 82, 79, 90, 33, 90, 61};
        int[] topThree = findTopThreeScores(scores);
        
        System.out.println(java.util.Arrays.toString(topThree)); 
    }

    /**
     * Finds the top 3 scores in a single pass without sorting the array.
     */
    public static int[] findTopThreeScores(int[] scores) {
        // Initialize to the smallest possible integer to handle arrays with low/negative scores
        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        for (int score : scores) {
            if (score > first) {
                // New highest score found: shift everything down
                third = second;
                second = first;
                first = score;
            } else if (score > second) {
                // Ties for first place, or a new second place found: shift third down
                third = second;
                second = score;
            } else if (score > third) {
                // Ties for second place, or a new third place found: replace third
                third = score;
            }
        }

        return new int[]{first, second, third};
    }
}