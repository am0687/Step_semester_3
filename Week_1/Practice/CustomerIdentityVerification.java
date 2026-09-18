public class CustomerIdentityVerification {

    public static void main(String[] args) {
        String customerName = "Sunil";
        
        String reversedName = reverseCustomerName(customerName);
        
        System.out.println("Original Name: " + customerName);
        System.out.println("Reversed Name: " + reversedName);
    }

    /**
     * Reverses the given customer name using character array manipulation.
     */
    public static String reverseCustomerName(String customerName) {
        // Convert the immutable String into a mutable character array
        char[] characters = customerName.toCharArray();
        int left = 0;
        int right = characters.length - 1;
        
        // Swap characters from the outside moving inwards
        while (left < right) {
            char temp = characters[left];
            characters[left] = characters[right];
            characters[right] = temp;
            
            left++;
            right--;
        }
        
        // Reconstruct a new String from the modified character array
        return new String(characters);
    }
}