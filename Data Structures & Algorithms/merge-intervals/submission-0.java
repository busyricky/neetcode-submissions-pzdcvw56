class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (a[0] - b[0]));

        List<int[]> resp = new ArrayList<>();

        int i = 0, n = intervals.length;

        while (i < n) {
            int start = intervals[i][0], end = intervals[i][1];

            while (i < n && end >= intervals[i][0]) {
                start = Math.min(intervals[i][0], start);
                end = Math.max(intervals[i][1], end);
                i++;
            }

            resp.add(new int[]{start,end});
        }

        return resp.toArray(new int[resp.size()][2]);
    }
}
