class Solution {
    Map<Integer, Integer> map = new HashMap<>();
    int max;

    public int coinChange(int[] coins, int amount) {
        max = amount + 1;
        int resp = max;

        for (int coin : coins) {
            map.put(coin, 1);
        }

        resp = Math.min(resp, dfs(coins, amount, coins[0], 0, 1));

        resp = Math.min(resp, dfs(coins, amount, 0, 1, 0));

        return resp == amount + 1 ? -1 : resp;
    }

    private int dfs(int[] coins, int amount, int sumSoFar, int i, int counter) {
        int diff = amount - sumSoFar;

        if (diff == 0) {
            return counter;
        } else if (diff < 0 || i >= coins.length) {
            return max;
        }

        if (map.containsKey(amount)) {
            return map.get(amount) + counter;
        }

        if (map.containsKey(sumSoFar)) {
            int x = Math.min(map.get(sumSoFar), counter);
            map.put(sumSoFar, x);
        } else {
            map.put(sumSoFar, counter);
        }
        
        int resp = max;
        
        resp = Math.min(resp, dfs(coins, amount, sumSoFar+coins[i], i, counter+1));

        resp = Math.min(resp, dfs(coins, amount, sumSoFar, i+1, counter));

        return resp;
    }
}
