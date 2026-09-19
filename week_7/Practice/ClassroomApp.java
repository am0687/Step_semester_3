class AttendanceSheet {
    // Private array safely tucks away the raw data
    private final String[] presentStudents;
    
    // Tracks both the total count and the index for the next insertion
    private int count;

    /**
     * Constructor initializes the sheet with a fixed maximum class size.
     */
    public AttendanceSheet(int maxCapacity) {
        if (maxCapacity <= 0) {
            maxCapacity = 30; // Fallback to a safe default if invalid input is given
        }
        this.presentStudents = new String[maxCapacity];
        this.count = 0;
    }

    /**
     * Scans the internal array to verify if a specific student is present.
     */
    public boolean isPresent(String name) {
        // Only loop up to 'count' to avoid searching empty (null) array slots
        for (int i = 0; i < count; i++) {
            if (this.presentStudents[i].equals(name)) {
                return true;
            }
        }
        return false;
    }

    /**
     * Marks a student present, enforcing capacity limits and rejecting duplicates.
     */
    public void markPresent(String name) {
        // Reuse the isPresent logic to prevent adding the same name twice
        if (isPresent(name)) {
            return; 
        }

        // Prevent OutOfBounds exceptions if the class overflows
        if (count < presentStudents.length) {
            presentStudents[count] = name;
            count++;
        } else {
            System.out.println("Rejected: Attendance sheet is completely full.");
        }
    }

    /**
     * Read-only getter that safely exposes the computed metric.
     */
    public int getPresentCount() {
        return this.count;
    }
}

public class ClassroomApp {

    public static void main(String[] args) {
        AttendanceSheet sheet = new AttendanceSheet(30);
        
        sheet.markPresent("Ana"); 
        sheet.markPresent("Ben"); 
        sheet.markPresent("Ana"); // Attempted duplicate, safely ignored
        
        System.out.println("Count -> " + sheet.getPresentCount());
        System.out.println("isPresent(\"Ben\") -> " + sheet.isPresent("Ben"));
        System.out.println("isPresent(\"Chen\") -> " + sheet.isPresent("Chen"));
    }
}