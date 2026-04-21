class Solution {
    public int numDecodings(String s) {
        int[] dp = new int[s.length() + 1];
        dp[s.length()] = 1;

        for (int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if (c == '0') {
                dp[i] = 0;
            } else if (i == s.length() - 1) {
                dp[i] = 1;
            } else {
                char d = s.charAt(i+1);

                if (d == '0') {
                    if (c != '1' && c != '2') {
                        return 0;
                    } else {
                        dp[i] = dp[i+2];
                    }
                } else if (c == '1' || (c == '2' && d < '7')) {
                    dp[i] = dp[i+1] + dp[i+2];
                } else {
                    dp[i] = dp[i+1];
                }
            }
        }

        return dp[0];
    }
}
