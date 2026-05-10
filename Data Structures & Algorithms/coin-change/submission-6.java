class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount+1];
        for (int i = 0; i < amount + 1; i++) {
            dp[i] = -1;
        }
        dp[0] = 0;

        for (int i = 1; i < amount + 1; i++) {
            int dpVal = Integer.MAX_VALUE;
            for (int coin : coins) {
                int diff = i - coin;
                if (diff >= 0 && dp[diff] != -1) {
                    dpVal = Math.min(dpVal, dp[diff] + 1);
                }
            }
            if (dpVal != Integer.MAX_VALUE) {
                dp[i] = dpVal;
            }
        }

        return dp[amount];
    }
}
