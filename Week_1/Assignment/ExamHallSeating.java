public class ExamHallSeating {

    public static void main(String[] args) {
        int[] hallA = {101, 102, 103, 102, 105};
        int[] hallB = {101, 102, 103, 104, 105};
        
        System.out.print("Hall A -> ");
        checkDuplicateSeats(hallA);
        
        System.out.print("Hall B -> ");
        checkDuplicateSeats(hallB);
    }

    /**
     * Scans an array of seat numbers for duplicates using only nested loops.
     */
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean foundDuplicate = false;
        int n = seatNumbers.length;
        
        for (int i = 0; i < n; i++) {
            // Check if this seat number was already processed to avoid printing 
            // the same duplicate multiple times if it appears 3+ times.
            boolean alreadyPrinted = false;
            for (int k = 0; k < i; k++) {
                if (seatNumbers[i] == seatNumbers[k]) {
                    alreadyPrinted = true;
                    break;
                }
            }
            
            if (alreadyPrinted) {
                continue;
            }
            
            // Compare the current seat against all remaining seats in the array
            for (int j = i + 1; j < n; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    foundDuplicate = true;
                    break; // Move to the next outer element once a duplicate is confirmed
                }
            }
        }
        
        if (!foundDuplicate) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}