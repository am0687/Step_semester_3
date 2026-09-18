import java.util.Arrays;

public class FantasyScoreMultiplier {

    public static void main(String[] args) {
        double[] scores = {40, 55, 30, 62};
        
        // The method modifies the array in place; no return assignment is needed.
        applyMultipliers(scores, 1, 3);
        
        // Print the updated scoreboard
        System.out.println(Arrays.toString(scores));
    }

    /**
     * Applies a 2x multiplier to the captain and a 1.5x multiplier to the vice-captain.
     */
    public static void applyMultipliers(double[] playerScores, int captainIndex, int viceCaptainIndex) {
        if (playerScores == null) {
            return;
        }
        
        // Directly update the specific indices without looping
        playerScores[captainIndex] *= 2.0;
        playerScores[viceCaptainIndex] *= 1.5;
    }
}