class HallTicket {
    String studentName;
    int seatNumber;

    /**
     * Constructor to initialize the hall ticket's state.
     */
    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class HallTicketManager {

    public static void main(String[] args) {
        // Create one HallTicket object for Priya
        HallTicket priya = new HallTicket("Priya", 0);
        
        // Assign a second variable to point at that exact same object in memory
        HallTicket copy = priya;
        
        // Modify the object's state through the second variable
        copy.seatNumber = 45;
        
        // Observe the change through the first variable
        System.out.println("Priya's seatNumber (via first variable): " + priya.seatNumber);
        
        // Check if both variables hold the exact same memory address
        System.out.println("copy == priya: " + (copy == priya));
        
        // Create a third, completely separate object with identical data
        HallTicket separate = new HallTicket("Priya", 45);
        
        // Check if the new object shares a memory address with the original
        System.out.println("separate == priya: " + (separate == priya));
    }
}