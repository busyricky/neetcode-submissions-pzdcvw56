class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] change = new int[amount+1];

        for (int i = 1; i < amount + 1; i++) {
            change[i] = -1;

            for (int j = 0; j < coins.length; j++) {
                int changeDiff = -1;
                
                if(i - coins[j] >= 0) {
                    changeDiff = change[i - coins[j]];
                }

                if (changeDiff != -1 && change[i] != -1) {
                    change[i] = Math.min(change[i],changeDiff + 1);
                } else if (changeDiff != -1) {
                    change[i] = changeDiff + 1;
                }
            }
        }

        return change[amount];
    }
}
