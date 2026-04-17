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
        int rooms = 0;
        Collections.sort(intervals, (a,b) -> (Integer.compare(a.start, b.start)));
        Queue<Interval> heap = new PriorityQueue<>((a,b) -> (Integer.compare(a.end, b.end)));

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            while (!heap.isEmpty() && heap.peek().end <= interval.start) {
                heap.remove();
            }

            heap.add(interval);

            rooms = Math.max(rooms, heap.size());
        }

        return rooms;
    }
}
