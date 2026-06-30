class Solution {
    int directions[][] = {{1,0}, {-1,0}, {0,1}, {0,-1}};
    public void solve(char[][] board) {
        if (board == null || board.length == 0) return;

        int m = board.length;
        int n = board[0].length;

        
        for(int i=0;i<m;i++) {
            //Left
            if (board[i][0] == 'O') {
                dfs(board, i, 0);
            }
            //Right
            if (board[i][n-1] == 'O') {
                dfs(board, i, n-1);
            }
        }

        for(int j=0;j<n;j++) {
            //Top
            if (board[0][j] == 'O') {
                dfs(board, 0, j);
            }
            //Right
            if (board[m-1][j] == 'O') {
                dfs(board, m-1, j);
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (board[i][j] == 'O') {
                    board[i][j] = 'X';
                }
            }
        }

        for(int i=0;i<m;i++) {
            for(int j=0;j<n;j++) {
                if (board[i][j] == '#') {
                    board[i][j] = 'O';
                }
            }
        }
    }

    void dfs(char[][] board, int i, int j) {
        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || board[i][j] == '#' || board[i][j] == 'X') return;

        board[i][j] = '#';

        for(int[] direction : directions) {
            dfs(board, i + direction[0], j + direction[1]);
        }
    }
}
