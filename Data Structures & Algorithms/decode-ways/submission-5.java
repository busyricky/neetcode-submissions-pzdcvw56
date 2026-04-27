class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                dp[i] = 0;
            } else {
                dp[i] = dp[i+1];

                if (i+1 < s.length()) {
                    char d = s.charAt(i+1);

                    if (c == '1' || (c=='2') && (d <= '6')) {
                        dp[i] += dp[i+2];
                    }
                }
            }
        }

        return dp[0];
    }
}
