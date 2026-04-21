class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[1],b[1])));

        int currEnd = intervals[0][1], erase = 0;

        for (int i = 1; i < intervals.length; i++) {
            int[] interval = intervals[i];

            if (currEnd > interval[0]) { //overlap
                erase++;
                currEnd = Math.min(currEnd, interval[1]);
            } else {
                currEnd = Math.max(currEnd, interval[1]);
            }
        }

        return erase;
    }
}
