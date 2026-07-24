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
        for(int i=0;i<n;i++) {
            startTimes[i] = intervals.get(i).start;
            endTimes[i] = intervals.get(i).end;
        }

        Arrays.sort(startTimes);
        Arrays.sort(endTimes);

        int s = 0;
        int e = 0;
        int count = 0;
        int result = 0;

        while(s < n) {
            if (startTimes[s] < endTimes[e]) {
                s++;
                count++; //meeting room extra added
            }
            else {
                e++;
                count--; //meeting room freed up
            }
            result = Math.max(result, count); //Max rooms needed at any moment
        }

        return result;
    }
}
