class BookInventory {
    // Instance variables grouping related data together to prevent sync issues
    private String title;
    private String author;
    private int copiesAvailable;

    /**
     * Constructor to initialize the object's state upon creation.
     */
    public BookInventory(String title, String author, int copiesAvailable) {
        this.title = title;
        this.author = author;
        this.copiesAvailable = copiesAvailable;
    }

    /**
     * Instance method that operates on the specific object's data.
     */
    public void printEntry() {
        System.out.printf("%s by %s - %d copies available\n", title, author, copiesAvailable);
    }
}

public class LibraryInventoryManager {

    public static void main(String[] args) {
        // Create an array capable of holding BookInventory objects
        BookInventory[] inventory = new BookInventory[4];
        
        // Instantiate and store objects in the array
        inventory[0] = new BookInventory("Clean Code", "Robert C. Martin", 3);
        inventory[1] = new BookInventory("Effective Java", "Joshua Bloch", 5);
        inventory[2] = new BookInventory("Refactoring", "Martin Fowler", 0);
        inventory[3] = new BookInventory("Design Patterns", "GoF", 2);

        // Iterate through the array and invoke the instance method on each object
        for (BookInventory book : inventory) {
            book.printEntry();
        }
    }
}