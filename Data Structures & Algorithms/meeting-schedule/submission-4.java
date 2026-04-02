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
        Collections.sort(intervals, (a,b) -> Integer.compare(a.start, b.start));

        int prevEnd = -1;
        for (Interval interval : intervals) {
            if (interval.end <= prevEnd || interval.start < prevEnd) {
                return false;
            }
            prevEnd = interval.end;
        }

        return true;
    }
}
