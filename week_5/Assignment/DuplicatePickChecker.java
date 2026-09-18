public class DuplicatePickChecker {

    public static void main(String[] args) {
        String[] lineup1 = {"Kohli", "Bumrah", "Kohli", "Rohit"};
        System.out.println(findDuplicatePick(lineup1));

        String[] lineup2 = {"Kohli", "Bumrah", "Rohit"};
        System.out.println(findDuplicatePick(lineup2));
    }

    /**
     * Scans an array of player names for the first duplicate using nested loops.
     */
    public static String findDuplicatePick(String[] playerNames) {
        if (playerNames == null) {
            return "No Duplicates Found";
        }

        int n = playerNames.length;

        // Outer loop selects the target player name
        for (int i = 0; i < n; i++) {
            // Inner loop compares the target against all SUBSEQUENT names in the lineup
            for (int j = i + 1; j < n; j++) {
                // Use .equals() for case-sensitive String value comparison
                if (playerNames[i].equals(playerNames[j])) {
                    return "Duplicate Found: " + playerNames[i];
                }
            }
        }

        return "No Duplicates Found";
    }
}