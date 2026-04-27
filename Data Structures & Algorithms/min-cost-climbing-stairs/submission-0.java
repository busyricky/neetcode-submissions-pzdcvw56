class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length + 2];

        for (int i = 0; i < dp.length; i++) {
            dp[i] = Integer.MAX_VALUE;
        }

        dp[0] = 0;
        dp[1] = 0;

        for (int i = 0; i < cost.length; i++) {
            int step = dp[i] + cost[i];
            dp[i+1] = Math.min(dp[i+1], step);
            dp[i+2] = Math.min(dp[i+2], step);
        }

        return dp[cost.length];
    }
}
