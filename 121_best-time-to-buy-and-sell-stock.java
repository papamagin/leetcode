https://leetcode.com/problems/best-time-to-buy-and-sell-stock/description/
class Solution {
    private int res = 0;
    private int currProfit = 0;
    private int buyPrice = Integer.MAX_VALUE;
    private int sellPrice = Integer.MIN_VALUE;
    
    public int maxProfit(int[] prices) {
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < buyPrice && i < prices.length - 1) {
                buyPrice = prices[i];
                sellPrice = prices[i + 1];
                updateRes();
            } else if (prices[i] > sellPrice) {
                sellPrice = prices[i];
                updateRes();
            } 
        }

        return res;
    }

    private void updateRes() {
        int profit = sellPrice - buyPrice;
        currProfit = profit > 0 ? profit : 0;
        if (currProfit > res) {
            res = currProfit;
        } 
    }
}
