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
    public int minMeetingRooms(List<Interval> intervals) {
        Collections.sort(intervals, (a,b) -> (Integer.compare(a.start,b.start)));

        int rooms = 0;

        List<Interval> remaining = new ArrayList<Interval>();


        while (!intervals.isEmpty()) {
            int prevEnd = -1;

            for (Interval interval : intervals) {
                if (interval.start < prevEnd) {
                    remaining.add(interval);
                } else {
                    prevEnd = interval.end;
                }
            }

            intervals = remaining;
            remaining = new ArrayList<Interval>();
            rooms++;
        }

        return rooms;
    }
}
