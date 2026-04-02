class Solution {
    public int[][] insert(int[][] intervals, int[] newInterval) {
        List<int[]> list = new ArrayList<>();

        int i = 0, n = intervals.length;
        while (i < n) {
            if (intervals[i][1] < newInterval[0]) {
                list.add(intervals[i]);
                i++;
            } else {
                break;
            }
        }

        int[] insertInterval = newInterval;

        while (i < n) {
            if (intervals[i][1] >= insertInterval[0]) {
                insertInterval[0] = Math.min(intervals[i][0],insertInterval[0]);
            }

            if (insertInterval[1] >= intervals[i][0]) {
                insertInterval[1] = Math.max(intervals[i][1],insertInterval[1]);
            } else {
                break;
            }

            i++;
        }
        
        list.add(insertInterval);

        while (i < n) {
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
