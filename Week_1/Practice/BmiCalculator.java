import java.util.Random;

public class BmiCalculator {

    public static void main(String[] args) {
        int teamSize = 10;
        double[] heights = new double[teamSize];
        double[] weights = new double[teamSize];
        Random random = new Random();

        // Generate random mock data for a live demo
        for (int i = 0; i < teamSize; i++) {
            // Height between 1.50m and 2.00m
            heights[i] = 1.50 + (random.nextDouble() * 0.50);
            // Weight between 45kg and 120kg
            weights[i] = 45.0 + (random.nextDouble() * 75.0);
        }

        printWellnessReport(heights, weights);
    }

    /**
     * Calculates BMI, determines status, and prints the formatted wellness report.
     */
    public static void printWellnessReport(double[] heights, double[] weights) {
        System.out.println("=======================================================================");
        System.out.printf("%-10s | %-12s | %-12s | %-8s | %-15s\n", 
                          "Person", "Height (m)", "Weight (kg)", "BMI", "Status");
        System.out.println("-----------------------------------------------------------------------");
        
        for (int i = 0; i < heights.length; i++) {
            double height = heights[i];
            double weight = weights[i];
            
            // BMI Formula: weight / (height * height)
            double bmi = weight / (height * height);
            String status = getBmiStatus(bmi);
            
            // Formatting decimal numbers to 2 places for clean alignment
            System.out.printf("Person %-3d | %-12.2f | %-12.2f | %-8.2f | %-15s\n", 
                              (i + 1), height, weight, bmi, status);
        }
        System.out.println("=======================================================================");
    }

    /**
     * Determines the health classification based on standard BMI thresholds.
     */
    public static String getBmiStatus(double bmi) {
        if (bmi < 18.5) {
            return "Underweight";
        } else if (bmi < 25.0) { // Covers 18.5 to 24.99
            return "Normal";
        } else if (bmi < 30.0) { // Covers 25.0 to 29.99
            return "Overweight";
        } else {
            return "Obese";
        }
    }
}