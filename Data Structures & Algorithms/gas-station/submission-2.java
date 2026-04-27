class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int gasTotal = 0, costTotal = 0, maxDiff = Integer.MAX_VALUE, start = 0, diffSum = 0;

        for (int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
            diffSum += gas[i] - cost[i];
            if (diffSum < maxDiff) {
                maxDiff = diffSum;
                start = i + 1;
            }
        }

        return (gasTotal - costTotal < 0) ? -1 : start % gas.length;
    }
}
