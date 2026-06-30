class Solution {
    public void islandsAndTreasure(int[][] grid) {
        if (grid == null || grid.length == 0) return;

        Queue<int[]> q = new LinkedList<>();

        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 0) q.offer(new int[]{i,j});
            }
        }

        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        while(!q.isEmpty()) {
            int[] current = q.poll();

            int currentRow = current[0];
            int currentColumn = current[1];
            
            for(int []dir : directions) {
                int nextRow = currentRow + dir[0];
                int nextColumn = currentColumn + dir[1];
                if (nextRow < 0 || nextRow >= grid.length || nextColumn < 0 || nextColumn >= grid[0].length || grid[nextRow][nextColumn] != 2147483647)
                    continue;

                grid[nextRow][nextColumn] = grid[currentRow][currentColumn] + 1;

                q.offer(new int[]{nextRow, nextColumn});
            }
        }
    }
}
