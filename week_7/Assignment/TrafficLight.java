public class TrafficLight {
    // Private state so it cannot be tampered with directly
    private String currentColor;
    private final String id;

    // Constructor assigns the final ID and sets the initial state to RED
    public TrafficLight(String id) {
        this.id = id;
        this.currentColor = "RED";
    }

    // Safely cycles the traffic light forward in a strict order
    public void next() {
        switch (this.currentColor) {
            case "RED":
                this.currentColor = "GREEN";
                break;
            case "GREEN":
                this.currentColor = "YELLOW";
                break;
            case "YELLOW":
                this.currentColor = "RED";
                break;
        }
    }

    // Read-only getter for the current color
    public String getColor() {
        return this.currentColor;
    }

    // Read-only getter for the final ID
    public String getId() {
        return this.id;
    }

    // Main method to demonstrate the expected behavior
    public static void main(String[] args) {
        TrafficLight t = new TrafficLight("TL-9");
        
        System.out.println("Initial color: " + t.getColor()); // "RED"
        
        t.next();
        System.out.println("After 1st next(): " + t.getColor()); // "GREEN"
        
        t.next();
        System.out.println("After 2nd next(): " + t.getColor()); // "YELLOW"
        
        t.next();
        System.out.println("After 3rd next(): " + t.getColor()); // "RED"
        
        // The ID is fixed and color cannot be skipped or set arbitrarily.
    }
}