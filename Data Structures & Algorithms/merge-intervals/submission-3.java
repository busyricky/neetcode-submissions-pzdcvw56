class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0],b[0])));

        int l = 0, r = 0;
        List<int[]> respList = new ArrayList<>();

        while (r < intervals.length) {
            int currentEnd = intervals[r][1];

            while (r < intervals.length && intervals[r][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd, intervals[r][1]);
                r++;
            }

            respList.add(new int[]{intervals[l][0], currentEnd});
            l = r;
        }

        int[][] respArr = new int[respList.size()][2];

        int counter = 0;
        for (int[] interval : respList) {
            respArr[counter] = interval;
            counter++;
        }

        return respArr;
    }
}
