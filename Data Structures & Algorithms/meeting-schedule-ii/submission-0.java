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
        int n = intervals.size();
        int[] startTimes = new int[n];
        int[] endTimes = new int[n];
        int i = 0;
        for(Interval interval : intervals) {
            startTimes[i] = interval.start;
            endTimes[i] = interval.end;
            i++;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int count = 0;
        int s = 0;
        int e = 0;
        int result = 0;
        while(s < n) {
            if (startTimes[s] < endTimes[e]) {
                s++;
                count++;
            }
            else {
                e++;
                count--;
            }
            result = Math.max(count, result);
        }
        return result;

    }
}
