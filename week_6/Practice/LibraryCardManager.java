class IdCard {
    String name;
    int booksIssued;

    /**
     * Constructor to initialize the ID card's state.
     */
    public IdCard(String name, int booksIssued) {
        this.name = name;
        this.booksIssued = booksIssued;
    }
}

public class LibraryCardManager {

    public static void main(String[] args) {
        // Create one IdCard object for Ravi
        IdCard ravi = new IdCard("Ravi", 0);
        
        // Assign a second variable to point at that exact same object in memory
        IdCard duplicate = ravi;
        
        // Modify the object's state through the second variable
        duplicate.booksIssued = 3;
        
        // Observe the change through the first variable
        System.out.println("Ravi's booksIssued (via first variable): " + ravi.booksIssued);
        
        // Check if both variables hold the exact same memory address
        System.out.println("duplicate == ravi: " + (duplicate == ravi));
        
        // Create a third, completely separate object with identical data
        IdCard separate = new IdCard("Ravi", 3);
        
        // Check if the new object shares a memory address with the original
        System.out.println("separate == ravi: " + (separate == ravi));
    }
}