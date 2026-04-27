class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int tank = 0, start = 0, gasTotal = 0, costTotal = 0;

        for (int i = 0; i < gas.length; i++) {
            gasTotal += gas[i];
            costTotal += cost[i];
        }

        if (gasTotal - costTotal < 0) { return -1; }

        for (int i = 0; i < gas.length; i++) {
            tank += gas[i] - cost[i];
            if (tank < 0) {
                start = i + 1;
                tank = 0;
            }
        }

        return start;
    }
}
