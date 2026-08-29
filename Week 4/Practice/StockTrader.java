public class StockTrader {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
        
        int lowestPrice = prices[0]; 
        int maxProfit = 0; 
        
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < lowestPrice) {
                lowestPrice = prices[i];
            } else {
                int currentProfit = prices[i] - lowestPrice;
                if (currentProfit > maxProfit) {
                    maxProfit = currentProfit;
                }
            }
        }
        return maxProfit;
    }

    public static void main(String[] args) {
        StockTrader trader = new StockTrader();
        
        int[] prices1 = {7, 1, 5, 3, 6, 4};
        System.out.println("Input: prices = [7, 1, 5, 3, 6, 4]");
        System.out.println("Output: " + trader.maxProfit(prices1));
        
        int[] prices2 = {7, 6, 4, 3, 1};
        System.out.println("Input: prices = [7, 6, 4, 3, 1]");
        System.out.println("Output: " + trader.maxProfit(prices2));
    }
}