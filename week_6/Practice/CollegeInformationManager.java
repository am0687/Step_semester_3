class Student {
    // Instance fields: unique to each individual student object
    private String name;
    private int attendance;

    // Static fields: shared collectively by all instances of the class
    private static String collegeName = "SRM Institute of Science and Technology";
    private static int studentCount = 0;

    /**
     * Constructor initializes instance fields and updates the shared static counter.
     */
    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        
        // Increment the class-level counter every time a new object is instantiated
        studentCount++;
    }

    /**
     * Static method that prints class-level information.
     */
    public static void printCollegeInfo() {
        // This method can only access static fields. Attempting to print 'name' here 
        // would cause a compiler error because there is no specific object context.
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class CollegeInformationManager {

    public static void main(String[] args) {
        // Create two separate Student objects
        Student student1 = new Student("Alice", 85);
        Student student2 = new Student("Bob", 92);

        // Call the static method directly through the Class name, not the object references
        Student.printCollegeInfo();
    }
}