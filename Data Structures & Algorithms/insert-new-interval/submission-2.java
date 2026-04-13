class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        for (int[] interval : intervals) {
            list.add(interval);
        }
        list.add(newInterval);
        Collections.sort(list, (a,b) -> (Integer.compare(a[0],b[0])));
        
        List<int[]> respList = new ArrayList<>();

        int[] curr = list.get(0);

        for (int i = 1; i < list.size(); i++) {
            int[] interval = list.get(i);

            if (curr[1] >= interval[0]) {
                curr[1] = Math.max(curr[1], interval[1]);
            } else {
                respList.add(curr);
                curr = interval;
            }
        }

        respList.add(curr);

        int[][] resp = new int[respList.size()][2];

        for (int i = 0; i < respList.size(); i++) {
            resp[i] = respList.get(i);
        }

        return resp;
    }
}
