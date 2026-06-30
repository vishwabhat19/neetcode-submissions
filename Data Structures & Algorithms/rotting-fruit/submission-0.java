class Solution {
    public int orangesRotting(int[][] grid) {
        int minutes = 0;
        boolean didAnythingRot = false;
        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();
        int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
        for(int i=0;i<grid.length;i++) {
            for(int j=0;j<grid[0].length;j++) {
                if (grid[i][j] == 2) {
                    q.offer(new int[]{i,j});
                }
                if (grid[i][j] == 1) {
                    fresh++;
                }
            }
        }

        while(!q.isEmpty()) {
            int size = q.size();
            for(int i=0;i<size;i++) {
                int current[] = q.poll();
                int currentRow = current[0];
                int currentColumn = current[1];

                for(int dir[] : directions) {
                    int nextRow = currentRow + dir[0];
                    int nextColumn = currentColumn + dir[1];

                    if (nextRow < 0 || nextColumn < 0 || nextRow >= grid.length || nextColumn >= grid[0].length || grid[nextRow][nextColumn] != 1) 
                        continue;

                    grid[nextRow][nextColumn] = 2;
                    q.offer(new int[]{nextRow, nextColumn});
                    didAnythingRot = true;
                    fresh--;
                }
            }
            if (didAnythingRot) minutes++;
            didAnythingRot = false;
        }

        if (fresh > 0) return -1;
        return minutes;
        
    }
}
