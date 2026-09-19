class Scorecard {
    // Private array completely hides the raw data from the outside world
    private final boolean[] results;
    
    // State tracker to know where the next answer should be placed
    private int currentIndex;

    /**
     * Constructor locks in the size of the scorecard upon creation.
     */
    public Scorecard(int totalQuestions) {
        // Prevent creation of a 0 or negative sized array
        if (totalQuestions <= 0) {
            totalQuestions = 1; 
        }
        
        // The array is instantiated once with a fixed length
        this.results = new boolean[totalQuestions];
        this.currentIndex = 0;
    }

    /**
     * Records a single answer if there is still room on the scorecard.
     */
    public void recordAnswer(boolean isCorrect) {
        // Prevent OutOfBounds exception by ignoring answers beyond the fixed capacity
        if (currentIndex < results.length) {
            results[currentIndex] = isCorrect;
            currentIndex++;
        } else {
            System.out.println("Rejected: Scorecard is already full.");
        }
    }

    /**
     * Calculates the score dynamically by reading the private array.
     */
    public int getScore() {
        int score = 0;
        
        // Only loop up to the number of answers actually recorded
        for (int i = 0; i < currentIndex; i++) {
            if (results[i]) {
                score++;
            }
        }
        
        return score;
    }
}

public class QuizApp {

    public static void main(String[] args) {
        // Initialize a scorecard with a fixed size of 4 questions
        Scorecard sc = new Scorecard(4);
        
        // Record the sequence: correct, correct, wrong, correct
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        
        // Attempting to add a 5th answer will be rejected
        sc.recordAnswer(true); 
        
        // Retrieve and print the final computed score
        System.out.println("Final Score -> " + sc.getScore());
    }
}