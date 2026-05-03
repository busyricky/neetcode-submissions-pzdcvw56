/**
 * Definition of Interval:
 * public class Interval {
 *     public int start, end;
 *     public Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

class Solution {
    public boolean canAttendMeetings(List<Interval> intervals) {
        if (intervals.size() == 0) { return true; }

        Collections.sort(intervals, (a,b) -> (Integer.compare(a.start, b.start)));
        int currEnd = intervals.get(0).end;

        for (int i = 1; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            if (currEnd > interval.start) {
                return false;
            }
            
            currEnd = interval.end;
        }

        return true;
    }
}
