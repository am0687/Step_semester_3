class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    /**
     * Master constructor that directly initializes all fields.
     */
    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    /**
     * Overloaded constructor for theory-only courses.
     * Chains to the master constructor using this(...).
     */
    public Course(String code, String title, int credits) {
        // Must be the very first line in the constructor
        this(code, title, credits, 0); 
    }

    /**
     * Calculates and returns the combined credits.
     */
    public int totalCredits() {
        return this.credits + this.labCredits;
    }

    // Getter for the course code used in the print statement
    public String getCode() {
        return this.code;
    }
}

public class CourseManagement {

    public static void main(String[] args) {
        // Instantiate using the overloaded (theory-only) constructor
        Course theoryCourse = new Course("21CSC201J", "Data Structures", 4);
        
        // Instantiate using the master (theory + lab) constructor
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        // Print the results
        System.out.println(theoryCourse.getCode() + " total credits: " + theoryCourse.totalCredits());
        System.out.println(labCourse.getCode() + " total credits: " + labCourse.totalCredits());
    }
}