class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0],b[0])));

        List<int[]> list = new ArrayList<>();

        int l = 0, r = 0;

        while (r < intervals.length) {
            int s1 = intervals[l][0], e1 = intervals[l][1], s2 = intervals[r][0], e2 = intervals[r][1];

            while (r < intervals.length && s2 <= e1) {
                e1 = Math.max(e1,e2);
                r++;
                if (r < intervals.length) {
                    s2 = intervals[r][0];
                    e2 = intervals[r][1];
                }
            } 
            
            list.add(new int[]{s1,e1});
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
