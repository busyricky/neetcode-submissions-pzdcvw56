class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int respIdx = 0, minDiff = Integer.MAX_VALUE, pSum = 0;

        for (int i = 0; i < gas.length; i++) {
            pSum += gas[i] - cost[i];

            if (minDiff > pSum) {
                minDiff = pSum;
                respIdx = i+1;
            }
        }

        while (respIdx >= gas.length) {
            respIdx -= gas.length;
        }

        return pSum < 0 ? -1 : respIdx;
    }
}
