class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        boolean visited[] = new boolean[n+1];
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i = 0;i<=n;i++) {
            adjList.add(new ArrayList());
        }

        for(int i=0;i<times.length;i++) {
            adjList.get(times[i][0]).add(new int[]{times[i][1], times[i][2]});
        }

        int distances[] = new int[n+1];

        Arrays.fill(distances, Integer.MAX_VALUE);

        Queue<int[]> q = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        q.offer(new int[]{k, 0});
        distances[k] = 0;

        while(!q.isEmpty()) {
            int[] current = q.poll();
            int currentNodeValue = current[0];
            int currentNodeDistance = current[1];
            if (visited[currentNodeValue]) continue;
            visited[currentNodeValue] = true;
            for(int[] neighbor : adjList.get(currentNodeValue)) {
                int neighborNodeValue = neighbor[0];
                int edgeWeightToNeighbor = neighbor[1];
                int newCalculatedWeight = currentNodeDistance + edgeWeightToNeighbor;
                if (newCalculatedWeight < distances[neighborNodeValue]) {
                    distances[neighborNodeValue] = newCalculatedWeight;
                    q.offer(new int[]{neighborNodeValue, newCalculatedWeight});
                }
            }
        }

        int result = Integer.MIN_VALUE;
        for(int i=1;i<distances.length;i++) {
            if (distances[i] == Integer.MAX_VALUE) return -1;
            result = Math.max(result, distances[i]);
        }
        return result;
    }
}
