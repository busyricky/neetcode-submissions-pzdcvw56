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
        if (intervals.size() == 0) { return 0; }

        Queue<Integer> heap = new PriorityQueue<>();
        int rooms = 0;
        Collections.sort(intervals, (a,b) -> (Integer.compare(a.start,b.start)));

        for (int i = 0; i < intervals.size(); i++) {
            Interval interval = intervals.get(i);

            while (heap.size() != 0 && interval.start >= heap.peek()) {
                heap.poll();
            }

            heap.add(interval.end);

            rooms = Math.max(rooms, heap.size());
        }

        return rooms;
    }
}
