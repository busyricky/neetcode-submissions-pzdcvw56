class Solution {
    public int maxProfit(int[] prices) {
        int l = 0, profit = 0;

        for (int r = 1; r < prices.length; r++) {
            if (prices[r] <= prices[l]) {
                l = r;
            } else {
                profit = Math.max(profit, prices[r] - prices[l]);
            }
        }

        return profit;
    }
}
