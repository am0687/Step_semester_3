public class WarehouseInventory {

    public static void main(String[] args) {
        int[] sectionA = {20, 15, 30};
        int[] sectionB = {25, 10, 30};
        
        analyzeInventory(sectionA, sectionB);
    }

    /**
     * Analyzes inventory across two sections to verify balance and find the highest quantity item.
     */
    public static void analyzeInventory(int[] sectionA, int[] sectionB) {
        if (sectionA.length != sectionB.length) {
            System.out.println("Error: Section arrays must be of equal length.");
            return;
        }

        int totalA = 0;
        int totalB = 0;
        
        int maxQuantity = -1;
        String maxSection = "";
        int maxItemIndex = -1; 

        // Single pass traversal since arrays are of equal length
        for (int i = 0; i < sectionA.length; i++) {
            totalA += sectionA[i];
            totalB += sectionB[i];
            
            // Check Section A against the running maximum
            if (sectionA[i] > maxQuantity) {
                maxQuantity = sectionA[i];
                maxSection = "Section A";
                maxItemIndex = i + 1; // 1-based indexing for the report
            }
            
            // Check Section B against the running maximum
            if (sectionB[i] > maxQuantity) {
                maxQuantity = sectionB[i];
                maxSection = "Section B";
                maxItemIndex = i + 1;
            }
        }

        String status = (totalA == totalB) ? "Balanced" : "Not Balanced";

        System.out.printf("Section A Total: %d | Section B Total: %d | Status: %s | Highest Quantity: %d (%s, Item %d)\n", 
                          totalA, totalB, status, maxQuantity, maxSection, maxItemIndex);
    }
}