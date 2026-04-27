class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        int i = 0;
        List<int[]> list = new ArrayList<>();

        while (i < intervals.length && intervals[i][1] < newInterval[0]) {
            list.add(intervals[i]);
            i++;
        }

        int[] curr = newInterval;

        while (i < intervals.length && intervals[i][0] <= curr[1]) {
            int[] interval = intervals[i];
            curr[0] = Math.min(interval[0], curr[0]);
            curr[1] = Math.max(interval[1], curr[1]);
            i++;
        }

        list.add(curr);

        while (i < intervals.length) {
            list.add(intervals[i]);
            i++;
        }

        int[][] resp = new int[list.size()][2];

        for (int j = 0; j < list.size(); j++) {
            resp[j] = list.get(j);
        }

        return resp;
    }
}
