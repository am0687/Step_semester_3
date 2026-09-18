public class SeatingGridOptimizer {

    public static void main(String[] args) {
        int[][] seatingScores = {
            {40, 50, 45},
            {85, 90, 95},
            {30, 20, 25}
        };
        
        System.out.println(classifyRows(seatingScores, 60));
    }

    /**
     * Iterates through a 2D seating grid and classifies each row based on its average.
     */
    public static String classifyRows(int[][] seatingScores, int threshold) {
        if (seatingScores == null || seatingScores.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < seatingScores.length; i++) {
            // Delegate the math to the reusable helper method
            double avg = rowAverage(seatingScores[i]);
            
            // Classify based on the returned average
            String classification = (avg >= threshold) ? "Buzzing Zone" : "Quiet Zone";
            
            result.append("Row ").append(i).append(": ").append(classification);
            
            // Append the separator for all but the very last row
            if (i < seatingScores.length - 1) {
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
        for (int score : row) {
            sum += score;
        }

        // Cast to double before division to prevent integer truncation
        return (double) sum / row.length;
    }
}