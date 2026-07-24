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
        if (intervals == null || intervals.size() == 0 || intervals.size() == 1) return true;
        intervals.sort((a,b) -> a.start - b.start);
        int currentEnd = intervals.get(0).end;
        for(int i=1;i<intervals.size();i++) {
            int nextStart = intervals.get(i).start;
            if (currentEnd > nextStart) {
                return false;
            }
            else {
                currentEnd = intervals.get(i).end;
            }
        }
        return true;
    }
}
