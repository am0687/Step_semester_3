public class StudentRecordParser {

    public static void main(String[] args) {
        parseStudentRecord("Ananya Verma,RA2211003010123,CSE");
        parseStudentRecord("Ananya Verma,CSE");
    }

    /**
     * Parses a CSV line and prints a formatted student record.
     */
    public static void parseStudentRecord(String csvLine) {
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the string into an array of fields using the comma delimiter
        String[] fields = csvLine.split(",");

        // Validate that exactly 3 fields exist (Name, RollNumber, Department)
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Trim each field to remove any accidental leading/trailing spaces
            String name = fields[0].trim();
            String rollNo = fields[1].trim();
            String dept = fields[2].trim();

            // Print the formatted output
            System.out.printf("Name: %s | Roll No: %s | Dept: %s\n", name, rollNo, dept);
        }
    }
}