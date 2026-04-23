class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit = 0;
        int stock = prices[0];

        for(int i = 1 ; i < prices.length ; i++) {
            if(prices[i] <= stock) {
                stock = prices[i];
            } else{
                maxProfit = Math.max(maxProfit, prices[i] - stock);
            }
        }

        return maxProfit;
    }
}