public class TrafficSignalAnalyzer {

    public static void main(String[] args) {
        findLongestStreak("RRGGGYRR");
        findLongestStreak("RRRRYYGG");
    }

    /**
     * Scans a string of signal readings to find the longest continuous streak 
     * of a single color.
     */
    public static void findLongestStreak(String signalLog) {
        if (signalLog == null || signalLog.isEmpty()) {
            System.out.println("Error: Empty signal log.");
            return;
        }

        int maxStreak = 0;
        char longestColor = ' ';
        
        int currentStreak = 1;
        char currentColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {
            if (signalLog.charAt(i) == currentColor) {
                // Continue the streak
                currentStreak++;
            } else {
                // Streak broken: check if it's the longest we've seen so far
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                    longestColor = currentColor;
                }
                // Reset for the new color
                currentColor = signalLog.charAt(i);
                currentStreak = 1;
            }
        }

        // Final check: in case the longest streak is at the very end of the string
        if (currentStreak > maxStreak) {
            maxStreak = currentStreak;
            longestColor = currentColor;
        }

        System.out.printf("Longest Streak: '%c' repeated %d times\n", longestColor, maxStreak);
    }
}