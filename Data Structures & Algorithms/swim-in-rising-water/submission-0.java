class Solution {
    public int swimInWater(int[][] grid) {
        int n = grid.length;
        PriorityQueue<int[]> pq = new PriorityQueue<>((a,b) -> a[2] - b[2]);
        boolean[][] visited = new boolean[n][n];
        pq.offer(new int[]{0,0,grid[0][0]});
        int[][] directions = {{0,1}, {0,-1}, {1,0}, {-1,0}};
        while(!pq.isEmpty()) {
            int[] current = pq.poll();
            int r = current[0];
            int c = current[1];
            int maxEffort = current[2];
            if (visited[r][c]) continue;
            visited[r][c] = true;
            if (r == n-1 && c == n-1) return maxEffort;
            for(int[] dir : directions) {
                int nr = r + dir[0];
                int nc = c + dir[1];
                if (nr < 0 || nr >= n || nc < 0 || nc >= n || visited[nr][nc]) continue;
                int nextMax = Math.max(maxEffort, grid[nr][nc]);
                pq.offer(new int[]{nr, nc, nextMax});
            }
        }
        return 0;
    }
}
