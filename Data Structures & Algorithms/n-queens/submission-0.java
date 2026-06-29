class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<>();
        char[][] grid = new char[n][n];
        for(char []rows : grid) {
            Arrays.fill(rows, '.');
        }
        boolean[] queenInColumn = new boolean[n];
        Set<Integer> diag = new HashSet<>();
        Set<Integer> antiDiag = new HashSet<>();
        solve(result, n, 0, queenInColumn, grid, diag, antiDiag);
        return result;
    }

    void solve(List<List<String>> result, int n, int rowIndex, boolean[] queenInColumn, char[][] grid, Set<Integer> diag, Set<Integer> antiDiag) {
        if (rowIndex == n) {
            List<String> tempList = new ArrayList();
            for(char[] row : grid) {
                tempList.add(new String(row));
            }
            result.add(new ArrayList(tempList));
            
        }

        for(int column=0;column<n;column++) {
            if (queenInColumn[column] || antiDiag.contains(rowIndex - column) || diag.contains(rowIndex + column)) continue;
            grid[rowIndex][column] = 'Q';
            queenInColumn[column] = true;
            diag.add(rowIndex + column);
            antiDiag.add(rowIndex - column);
            solve(result, n, rowIndex + 1, queenInColumn, grid, diag, antiDiag);
            grid[rowIndex][column] = '.';
            queenInColumn[column] = false;
            diag.remove(rowIndex + column);
            antiDiag.remove(rowIndex - column);
        }

    }
}
