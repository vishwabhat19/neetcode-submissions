class Solution {
    public int[][] merge(int[][] intervals) {
        int n = intervals.length;
        List<int[]> result = new ArrayList<>();
        Arrays.sort(intervals, (a,b) -> a[0]-b[0]);
        int[] currentInterval = intervals[0];
        result.add(currentInterval);
        for(int i=0;i<n;i++) {
            int currentEnd = currentInterval[1];
            int nextStart = intervals[i][0];
            int nextEnd = intervals[i][1];
            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentInterval[1], nextEnd); 
            }
            else {
                currentInterval = intervals[i];
                result.add(currentInterval);
            }
        }
        return result.toArray(new int[result.size()][]);
    }
}
