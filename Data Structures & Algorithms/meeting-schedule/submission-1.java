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
        for (int i = 0; i < intervals.size(); i++) {
            int sOne = intervals.get(i).start, eOne = intervals.get(i).end;

            for (int j = i + 1; j < intervals.size(); j++) {
                    int sTwo = intervals.get(j).start, eTwo = intervals.get(j).end;

                    if ((sOne < sTwo && sTwo < eOne) || (sTwo < eOne && eOne < eTwo) ||
                        (sOne <= sTwo && eTwo <= eOne) || (sTwo <= sOne && eOne <= eTwo)
                    ) {
                        return false;
                    }
            }
        }

        return true;
    }
}
