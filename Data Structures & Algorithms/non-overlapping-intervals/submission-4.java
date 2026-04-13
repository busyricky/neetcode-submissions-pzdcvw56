class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0],b[0])));

        int remove = 0, lastEnd = intervals[0][1];

        for (int i = 1; i < intervals.length; i++) {
            int[] curr = intervals[i];

            if (lastEnd > curr[0]) {
                remove++;
                lastEnd = Math.min(lastEnd, curr[1]);
            } else {
                lastEnd = curr[1];
            }
        }

        return remove;
    }
}
