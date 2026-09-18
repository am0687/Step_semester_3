public class InventoryParser {

    public static void main(String[] args) {
        parseInventoryRecord("Wireless Mouse,WM-2201,150");
        parseInventoryRecord("Wireless Mouse,150");
    }

    /**
     * Parses a CSV line and prints a formatted inventory record.
     */
    public static void parseInventoryRecord(String csvLine) {
        // Handle null or completely empty inputs safely
        if (csvLine == null || csvLine.trim().isEmpty()) {
            System.out.println("Invalid Record");
            return;
        }

        // Split the input string using the comma delimiter
        String[] fields = csvLine.split(",");

        // Validate that the array contains exactly 3 elements
        if (fields.length != 3) {
            System.out.println("Invalid Record");
        } else {
            // Trim whitespace to handle poorly formatted inputs like "Item , SKU , 10"
            String product = fields[0].trim();
            String sku = fields[1].trim();
            String qty = fields[2].trim();

            // Print the validated and formatted string
            System.out.printf("Product: %s | SKU: %s | Qty: %s\n", product, sku, qty);
        }
    }
}