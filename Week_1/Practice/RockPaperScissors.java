import java.util.Random;

public class RockPaperScissors {

    public static void main(String[] args) {
        int n = 5;
        // Using a predefined list of moves for the player for a live automated demo
        String[] demoPlayerMoves = {"Rock", "Paper", "Scissors", "Rock", "Paper"};
        String[] options = {"Rock", "Paper", "Scissors"};
        Random random = new Random();

        // Arrays to record history for the final summary table
        String[] playerMovesHistory = new String[n];
        String[] computerMovesHistory = new String[n];
        String[] resultsHistory = new String[n];

        int wins = 0, losses = 0, draws = 0;

        System.out.println("--- Arcade Match Started ---");
        for (int i = 0; i < n; i++) {
            String playerMove = demoPlayerMoves[i];
            String computerMove = options[random.nextInt(3)];
            
            String result = playRound(playerMove, computerMove);
            
            // Record history
            playerMovesHistory[i] = playerMove;
            computerMovesHistory[i] = computerMove;
            resultsHistory[i] = result;

            // Tally score
            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("Round %d — Player: %s, Computer: %s -> %s\n", 
                              (i + 1), playerMove, computerMove, result);
        }

        // Print final summary table
        System.out.println("\n===============================================================");
        System.out.printf("%-10s | %-15s | %-15s | %-15s\n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("---------------------------------------------------------------");
        for (int i = 0; i < n; i++) {
            System.out.printf("%-10d | %-15s | %-15s | %-15s\n", 
                              (i + 1), playerMovesHistory[i], computerMovesHistory[i], resultsHistory[i]);
        }
        System.out.println("===============================================================");

        // Calculate and print statistics
        double winPercentage = ((double) wins / n) * 100;
        System.out.printf("Final Summary: Wins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%\n", 
                          wins, losses, draws, winPercentage);
    }

    /**
     * Determines the winner of a single Rock-Paper-Scissors round.
     */
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equals(computerMove)) {
            return "Draw";
        }
        
        if ((playerMove.equals("Rock") && computerMove.equals("Scissors")) ||
            (playerMove.equals("Paper") && computerMove.equals("Rock")) ||
            (playerMove.equals("Scissors") && computerMove.equals("Paper"))) {
            return "Player Wins";
        }
        
        return "Computer Wins";
    }
}