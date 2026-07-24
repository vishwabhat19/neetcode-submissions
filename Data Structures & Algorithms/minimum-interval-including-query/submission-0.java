class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        int n = intervals.length;
        int q = queries.length;

        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int[][] sortedQueries = new int[q][2];
        for(int i=0;i<sortedQueries.length;i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i; // original index
        }

        Arrays.sort(sortedQueries, (a,b) -> a[0]-b[0]);

        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a,b) -> Integer.compare(a[0], b[0]));
        int[] result = new int[q];
        int i = 0;

        for(int[] queryObj : sortedQueries) {
            int queryVal = queryObj[0];
            int originalIndex = queryObj[1];

            //Add intervals which have their start equal or before the query point
            while (i<n && intervals[i][0] <= queryVal) {
                int length = intervals[i][1] - intervals[i][0] + 1;
                minHeap.offer(new int[]{length, intervals[i][1]});
                i++;
            }

            //Remove all intervals that end before the query point
            while(!minHeap.isEmpty() && minHeap.peek()[1] < queryVal) {
                minHeap.poll();
            }

            //Top of the minHeap now is the smallest interval that start
            //before the query point and end after the query point
            //and the smallest length
            result[originalIndex] = minHeap.isEmpty() ? -1 : minHeap.peek()[0];
        }
        return result;
    }
}
