class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> boxMap = new HashMap();
        Map<Integer, Set<Character>> rowMap = new HashMap();
        Map<Integer, Set<Character>> colMap = new HashMap();
        for(int i=0;i<9;i++) {
            boxMap.put(i, new HashSet());
            rowMap.put(i, new HashSet());
            colMap.put(i, new HashSet());
        }

        for(int i=0;i<9;i++) {
            for(int j=0;j<9;j++) {
                if (board[i][j] == '.') continue;
                int box = (i/3) * 3 + (j/3);
                Set<Character> set = boxMap.get(box);
                if (set.contains(board[i][j])) return false;
                set.add(board[i][j]);

                Set<Character> rowSet = rowMap.get(i);
                if (rowSet.contains(board[i][j])) return false;
                rowSet.add(board[i][j]);

                Set<Character> colSet = colMap.get(j);
                if (colSet.contains(board[i][j])) return false;
                colSet.add(board[i][j]);
            }
        }

        return true;
    }
}
