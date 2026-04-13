class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> list = new ArrayList<>();

        while (i < intervals.length) {
            int[] curr = intervals[i];

            if (newInterval[0] <= curr[1]) {
                break;
            }

            list.add(curr);

            i++;
        }

        while (i < intervals.length) {
            int[] curr = intervals[i];

            if (newInterval[1] < curr[0]) {
                break;
            }

            newInterval[0] = Math.min(newInterval[0], curr[0]);
            newInterval[1] = Math.max(newInterval[1], curr[1]);
            i++;
        }
        list.add(newInterval);

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        return list.toArray(new int[list.size()][]);
    }
}
