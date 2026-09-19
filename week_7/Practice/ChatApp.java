class NameTag {
    // Final fields guarantee that the object is strictly immutable after creation
    private final String firstName;
    private final char lastInitial;

    /**
     * Constructor parses the full name once and locks the components into memory.
     */
    public NameTag(String fullName) {
        // Split the string into an array based on the single space character
        String[] parts = fullName.split(" ");
        
        this.firstName = parts[0];
        // Extract strictly the very first character of the last name
        this.lastInitial = parts[1].charAt(0);
    }

    /**
     * Constructs and returns the formatted nickname.
     */
    public String getNickname() {
        return this.firstName + " " + this.lastInitial + ".";
    }
}

public class ChatApp {

    public static void main(String[] args) {
        NameTag tag = new NameTag("Maria Gomez");
        
        System.out.println("Nickname -> " + tag.getNickname());
    }
}