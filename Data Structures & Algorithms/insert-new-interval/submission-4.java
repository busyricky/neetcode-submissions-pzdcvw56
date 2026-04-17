class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();
        int i = 0;

        while (i < intervals.length) { //everything before new interval
            int[] interval = intervals[i];
            if (interval[1] >= newInterval[0]) {
                break;
            }
            list.add(interval);
            i++;
        }

        while (i < intervals.length) {  // insert new interval + merge overlaps
            int[] interval = intervals[i];
            if (interval[0] <= newInterval[1]) {
                newInterval[0] = Math.min(newInterval[0], interval[0]);
                newInterval[1] = Math.max(newInterval[1], interval[1]);
                i++;
            } else {
                break;
            }
        }

        list.add(newInterval);

        while (i < intervals.length) { // insert everything after new interval
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
