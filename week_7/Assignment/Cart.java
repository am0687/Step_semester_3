public class Cart {
    // Private state fully hidden from the outside
    private int[] prices;
    private int count;
    
    // Final ID fixed upon creation
    private final String cartId;

    // Constructor initializes the fixed ID and the maximum capacity of the cart
    public Cart(String cartId, int maxItems) {
        this.cartId = cartId;
        this.prices = new int[maxItems];
        this.count = 0;
    }

    // Adds a price to the cart if there is capacity
    public void addItem(int price) {
        if (count < prices.length) {
            this.prices[count] = price;
            count++;
        } else {
            System.out.println("Cart is full. Cannot add item.");
        }
    }

    // Dynamically computes the total upon request (no running total field stored)
    public int getTotal() {
        int total = 0;
        // Only loop up to 'count' to avoid processing empty array slots
        for (int i = 0; i < count; i++) {
            total += prices[i];
        }
        return total;
    }

    // Read-only getter for the item count
    public int getItemCount() {
        return this.count;
    }

    // Read-only getter for the Cart ID
    public String getCartId() {
        return this.cartId;
    }

    // Main method to demonstrate the expected behavior
    public static void main(String[] args) {
        Cart cart = new Cart("CART-5", 20);
        
        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);
        
        System.out.println("Cart ID: " + cart.getCartId());       // "CART-5"
        System.out.println("Total: " + cart.getTotal());          // 500
        System.out.println("Item count: " + cart.getItemCount()); // 3
        
        // Note: It is impossible to do cart.getPrices() as no such method exists!
    }
}