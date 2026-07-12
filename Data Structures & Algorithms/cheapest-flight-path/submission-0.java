class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0, 0});
        List<List<int[]>> adjList = new ArrayList<>();
        for(int i=0;i<n;i++) {
            adjList.add(new ArrayList());
        }

        for(int[] flight : flights) {
            adjList.get(flight[0]).add(new int[]{flight[1], flight[2]});
        }

        int[] minStops = new int[n];
        Arrays.fill(minStops, Integer.MAX_VALUE);
        minStops[src] = 0;

        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int u = current[0];
            int cost = current[1];
            int stops = current[2];

            if (u == dst) return cost;

            if (stops > k) continue;

            for(int[] next: adjList.get(u)) {
                int v = next[0];
                int price = next[1];
                pq.offer(new int[]{v, cost + price, stops + 1});
            }
        }

        return -1;
    }
}
