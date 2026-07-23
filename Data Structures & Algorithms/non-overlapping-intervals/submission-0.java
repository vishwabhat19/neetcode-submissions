class Solution {
    public int eraseOverlapIntervals(int[][] intervals) {
        int n = intervals.length;
        int removals = 0;
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int prevEnd = intervals[0][1];
        for(int i=1;i<n;i++) {
            int currentStart = intervals[i][0];
            int currentEnd = intervals[i][1];
            if (prevEnd > currentStart) {
                removals++;
                prevEnd = Math.min(prevEnd, currentEnd);
            }
            else {
                prevEnd = intervals[i][1];
            }
            
        }
        return removals;

    }
}
