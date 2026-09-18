class PlacementRecord {
    // Instance variables grouping related data together
    private String studentName;
    private String company;
    private double packageLpa;

    /**
     * Constructor to initialize the object's state upon creation.
     */
    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    /**
     * Instance method that operates on the specific object's data.
     */
    public void printRecord() {
        System.out.printf("%s -> %s @ %.1f LPA\n", studentName, company, packageLpa);
    }
}

public class PlacementManager {

    public static void main(String[] args) {
        // Create an array capable of holding PlacementRecord objects
        PlacementRecord[] records = new PlacementRecord[3];
        
        // Instantiate and store objects in the array
        records[0] = new PlacementRecord("Ravi", "TCS", 4.5);
        records[1] = new PlacementRecord("Anitha", "Zoho", 6.2);
        records[2] = new PlacementRecord("Karthik", "Infosys", 4.0);

        // Iterate through the array and invoke the instance method on each object
        for (PlacementRecord record : records) {
            record.printRecord();
        }
    }
}