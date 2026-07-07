class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        boolean visited[] = new boolean[n];
        PriorityQueue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        //arbitrarily start at the 0th point with 0 cost
        q.offer(new int[]{0, 0});
        int totalCost = 0;
        int edgesConnected = 0;
        while(!q.isEmpty() && edgesConnected < n) {
            int[] current = q.poll();
            int u = current[0];
            int cost = current[1];

            if (visited[u]) continue;

            visited[u] = true;
            totalCost = totalCost + cost;
            edgesConnected++;

            for(int v=0;v<n;v++) {
                if (!visited[v]) {
                    int distance = Math.abs(points[u][0] - points[v][0]) + Math.abs(points[u][1] - points[v][1]);
                    q.offer(new int[]{v, distance});
                }
            }
        }
        return totalCost;
    }
}
