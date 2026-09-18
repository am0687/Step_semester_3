import java.util.Arrays;

class Player implements Comparable<Player> {
    private String name;
    private int matchesPlayed;
    private double battingAverage;
    private boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    public String getName() { return name; }
    public int getMatchesPlayed() { return matchesPlayed; }
    public double getBattingAverage() { return battingAverage; }
    public boolean isInjured() { return injured; }

    @Override
    public int compareTo(Player other) {
        // Sort in descending order using battingAverage as the fantasy points metric
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class AutoDraftEngine {

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };
        
        System.out.println(draftAndRank(players));
    }

    /**
     * Overload 1: Track-record check for established players (Threshold: 10+ matches).
     */
    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    /**
     * Overload 2: Combined check for newer players (Threshold: 5+ matches AND completely fit).
     */
    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    /**
     * Filters draftable players, ranks them using Arrays.sort, and formats the output.
     */
    public static String draftAndRank(Player[] players) {
        if (players == null) return "";

        // Pass 1: Count draftable players to size the new array correctly
        int eligibleCount = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                eligibleCount++;
            }
        }

        // Pass 2: Populate the draftable array
        Player[] draftable = new Player[eligibleCount];
        int index = 0;
        for (Player p : players) {
            if (isDraftable(p.getMatchesPlayed()) || isDraftable(p.getMatchesPlayed(), p.isInjured())) {
                draftable[index++] = p;
            }
        }

        // Delegate the sorting entirely to the standard library
        Arrays.sort(draftable);

        // Format the final output string
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < draftable.length; i++) {
            result.append(i + 1).append(". ").append(draftable[i].getName());
            
            if (i < draftable.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }
}