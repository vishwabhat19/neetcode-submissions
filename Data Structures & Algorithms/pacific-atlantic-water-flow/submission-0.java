class Solution {
    int[][] directions = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        List<List<Integer>> result = new ArrayList<>();
        if (heights == null || heights.length == 0) return result;
        int m = heights.length;
        int n= heights[0].length;
        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        //DFS from ocean boundries
        //Left and right
        for(int i=0;i<m;i++) {
            //Left boundary
            dfs(heights, pacific, i, 0, heights[i][0]);
            //Right boundary
            dfs(heights, atlantic, i, n-1, heights[i][n-1]);
        }

        //Top and bottom
        for(int j=0;j<n;j++) {
            dfs(heights, pacific, 0, j, heights[0][j]);
            dfs(heights, atlantic, m-1, j, heights[m-1][j]);
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (pacific[i][j] && atlantic[i][j]) {
                    result.add(Arrays.asList(i,j));
                }
            }
        }

        return result;
        
    }

    public void dfs(int[][] heights, boolean reach[][], int i, int j, int prev) {
        if (i < 0 || j < 0 || i >= heights.length || j>= heights[0].length || heights[i][j] < prev || reach[i][j]) return;

        reach[i][j] = true;

        for(int[] direction : directions) {
            dfs(heights, reach, i+direction[0], j+direction[1], heights[i][j]);
        }
    }
}
