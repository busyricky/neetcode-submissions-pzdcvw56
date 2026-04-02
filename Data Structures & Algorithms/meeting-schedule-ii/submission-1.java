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

        PriorityQueue<Integer> heap = new PriorityQueue<>();

        int rooms = 0;

        for (Interval interval : intervals) {
            while (!heap.isEmpty() && heap.peek() <= interval.start) {
                heap.remove();
            }

            // if (heap.isEmpty() || )
            heap.add(interval.end);

            rooms = Math.max(rooms, heap.size());
        }

        return rooms;
    }
}
