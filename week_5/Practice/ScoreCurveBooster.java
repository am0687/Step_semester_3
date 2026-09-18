import java.util.Arrays;

public class ScoreCurveBooster {

    public static void main(String[] args) {
        int[] scores = {70, 85, 60};
        
        // The method modifies the array in place; no return assignment is needed.
        curveScores(scores, 10);
        
        // Print using the standard library's formatting helper
        System.out.println(Arrays.toString(scores));
    }

    /**
     * Modifies the provided array in place by adding a flat bonus to each score.
     */
    public static void curveScores(int[] scores, int bonus) {
        if (scores == null) {
            return;
        }
        
        for (int i = 0; i < scores.length; i++) {
            scores[i] += bonus;
        }
    }
}