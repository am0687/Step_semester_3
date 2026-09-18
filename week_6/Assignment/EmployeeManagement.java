class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    /**
     * Master constructor for permanent employees.
     * Initializes all fields and defaults isIntern to false.
     */
    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    /**
     * Overloaded constructor for interns.
     * Chains to the master constructor using this(...) and then overrides the intern status.
     */
    public Employee(String empId, String empName) {
        // Must be the very first line in the constructor
        this(empId, empName, 0.0); 
        
        // After the master constructor finishes, update the specific state for interns
        this.isIntern = true;
    }

    /**
     * Prints the employee profile in a single formatted line.
     */
    public void printProfile() {
        System.out.println(empId + " | " + empName + " | Rs " + salary + " | Intern: " + isIntern);
    }
}

public class EmployeeManagement {

    public static void main(String[] args) {
        // Instantiate using the master (permanent) constructor
        Employee permanentEmp = new Employee("E-101", "Divya", 65000);
        
        // Instantiate using the overloaded (intern) constructor
        Employee internEmp = new Employee("E-102", "Arjun");

        // Print the profiles
        permanentEmp.printProfile();
        internEmp.printProfile();
    }
}