class Employee {
    // Instance fields: unique to each individual employee object
    private String empName;
    private double salary;

    // Static fields: shared collectively by all instances of the class
    private static String companyName = "Bright Horizon Technologies";
    private static int employeeCount = 0;

    /**
     * Constructor initializes instance fields and updates the shared static counter.
     */
    public Employee(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        
        // Increment the class-level counter every time a new object is instantiated
        employeeCount++;
    }

    /**
     * Static method that prints class-level information.
     */
    public static void printCompanyInfo() {
        // This method can only access static fields. Attempting to print 'empName' here 
        // would cause a compiler error because there is no specific object context.
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class CompanyInformationManager {

    public static void main(String[] args) {
        // Create three separate Employee objects
        Employee emp1 = new Employee("Alice", 60000);
        Employee emp2 = new Employee("Bob", 65000);
        Employee emp3 = new Employee("Charlie", 70000);

        // Call the static method directly through the Class name, not the object references
        Employee.printCompanyInfo();
    }
}