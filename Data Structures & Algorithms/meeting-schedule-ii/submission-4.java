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
        Collections.sort(intervals, (a,b) -> (Integer.compare(a.start, b.start)));

        int maxSize = 0;
        Queue<Interval> qu = new PriorityQueue<Interval>((a,b) -> (Integer.compare(a.end, b.end)));
        
        for (int i = 0;  i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            while (!qu.isEmpty() && qu.peek().end <= interval.start) {
                qu.remove();
            }

            qu.offer(interval);
            maxSize = Math.max(maxSize, qu.size());
        }

        return maxSize;
    }
}
