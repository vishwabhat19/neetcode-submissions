class Solution {
    public int longestIncreasingPath(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) return 0;
        int maxPath = 0;
        int rows = matrix.length;
        int cols = matrix[0].length;
        Integer dp[][] = new Integer[rows+1][cols+1];
        for(int i=0;i<rows;i++) {
            for(int j=0;j<cols;j++) {
                maxPath = Math.max(maxPath, solve(matrix, i, j, dp));
            }
        }
        return maxPath;
    }

    int solve(int[][] matrix, int i, int j, Integer[][] dp) {
        int maxDirection = 0;

        if (dp[i][j] != null) return dp[i][j];

        int[][] dirs = {{1,0}, {-1,0}, {0,1}, {0,-1}};

        for(int []dir : dirs) {
            int nr = i + dir[0];
            int nc = j + dir[1];
            if (nr >= 0 && nr < matrix.length && nc >= 0 && nc < matrix[0].length && matrix[nr][nc] > matrix[i][j]) {
                maxDirection = Math.max(maxDirection, solve(matrix, nr, nc, dp));
            }
        }

        dp[i][j] = 1 + maxDirection;

        return 1 + maxDirection;
    }
}
