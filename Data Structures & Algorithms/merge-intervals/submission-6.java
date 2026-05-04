class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> (Integer.compare(a[0], b[0])));
        List<int[]> list = new ArrayList<>();

        int[] curr = intervals[0];

        for (int[] interval : intervals) {
            if (curr[1] >= interval[0]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                list.add(curr);
                curr = interval;
            }
        }

        list.add(curr);

        int[][] resp = new int[list.size()][2];

        for (int i = 0; i < list.size(); i++) {
            resp[i] = list.get(i);
        }

        return resp;
    }
}
