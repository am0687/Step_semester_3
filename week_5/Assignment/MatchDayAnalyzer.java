public class MatchDayAnalyzer {

    public static void main(String[] args) {
        int[][] runsPerOver = {
            {4, 6, 8},
            {10, 12, 14},
            {2, 3, 1}
        };
        
        System.out.println(classifyMatches(runsPerOver, 8));
    }

    /**
     * Iterates through a 2D match grid and classifies each match based on its average score.
     */
    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        if (runsPerOver == null || runsPerOver.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            // Delegate the math to the reusable helper method
            double avg = rowAverage(runsPerOver[i]);
            
            // Classify based on the returned average
            String classification = (avg >= threshold) ? "Power Surge" : "Normal";
            
            result.append("Match ").append(i).append(": ").append(classification);
            
            // Append the separator for all but the very last match
            if (i < runsPerOver.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    /**
     * Private helper method strictly responsible for calculating a single row's average.
     */
    private static double rowAverage(int[] row) {
        // Guard against empty or null rows in a jagged array
        if (row == null || row.length == 0) {
            return 0.0;
        }

        int sum = 0;
        for (int runs : row) {
            sum += runs;
        }

        // Cast to double before division to prevent integer truncation
        return (double) sum / row.length;
    }
}