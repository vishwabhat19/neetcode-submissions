class Solution {
    public boolean isValidSudoku(char[][] board) {
        Map<Integer, Set<Character>> rowMap = new HashMap<>();
        Map<Integer, Set<Character>> colMap = new HashMap<>();
        Map<Integer, Set<Character>> boxMap = new HashMap<>();
        for(int i=0;i<9;i++) {
            rowMap.put(i, new HashSet());
            colMap.put(i, new HashSet());
            boxMap.put(i , new HashSet());
        }
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if (board[i][j] == '.') continue;
                char c = board[i][j];
                if (rowMap.get(i).contains(c)) return false;
                else rowMap.get(i).add(c);
                if (colMap.get(j).contains(c)) return false;
                else colMap.get(j).add(c);
                int box = (j/3) * 3 + (i/3);
                if (boxMap.get(box).contains(c)) return false;
                else boxMap.get(box).add(c);
            }
        }
        return true;
    }
}
