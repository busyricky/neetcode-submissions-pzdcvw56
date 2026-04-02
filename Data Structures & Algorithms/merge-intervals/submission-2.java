class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0],b[0])));

        List<int[]> list = new ArrayList<>();

        int l = 0, r = 0;

        while (r < intervals.length) {
            int currentEnd = intervals[l][1];

            while (r < intervals.length && intervals[r][0] <= currentEnd) {
                currentEnd = Math.max(currentEnd,intervals[r][1]);
                r++;
            } 
            
            list.add(new int[]{intervals[l][0],currentEnd});
            l = r;
        }

        int[][] resp = new int[list.size()][2];
        int i = 0;

        for (int[] interval : list) {
            resp[i] = interval;
            i++;
        }

        return resp;
    }
}
