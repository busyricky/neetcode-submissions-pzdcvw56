class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0],b[0])));

        List<int[]> list = new ArrayList<>();

        int i = 0;

        while (i < intervals.length) {
            int[] interval = intervals[i];
            int currEnd = intervals[i][1];

            while (i < intervals.length && intervals[i][0] <= currEnd) {
                currEnd = Math.max(intervals[i][1], currEnd);
                i++;
            }

            list.add(new int[]{interval[0], currEnd});
        }

        int[][] resp = new int[list.size()][2];
        for (int j = 0; j < list.size(); j++) {
            resp[j] = list.get(j);
        }

        return resp;
    }
}
