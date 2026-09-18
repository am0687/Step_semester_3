public class DuplicateTeamFinder {

    public static void main(String[] args) {
        String[] teams1 = {"ByteForce", "CodeCrafters", "ByteForce"};
        System.out.println(findDuplicateTeam(teams1));
        
        String[] teams2 = {"ByteForce", "CodeCrafters", "NullPointers"};
        System.out.println(findDuplicateTeam(teams2));
    }

    /**
     * Scans an array of team names for the first duplicate using nested loops.
     */
    public static String findDuplicateTeam(String[] teamNames) {
        if (teamNames == null) {
            return "No Duplicates Found";
        }
        
        int n = teamNames.length;
        
        // Outer loop selects the target team name
        for (int i = 0; i < n; i++) {
            // Inner loop compares the target against all SUBSEQUENT names
            for (int j = i + 1; j < n; j++) {
                // Use .equals() for case-sensitive String value comparison
                if (teamNames[i].equals(teamNames[j])) {
                    return "Duplicate Found: " + teamNames[i];
                }
            }
        }
        
        return "No Duplicates Found";
    }
}