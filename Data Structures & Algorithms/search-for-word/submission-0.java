class Solution {
    public boolean exist(char[][] board, String word) {
        for(int i=0;i<board.length;i++) {
            for(int j=0;j<board[0].length;j++) {
                if (search(board, word, 0, i, j)) return true;
            }
        }
        return false;
    }

    public boolean search(char[][] board, String word, int wordIndex, int i, int j) {
        if (wordIndex == word.length())
            return true;

        if (i < 0 || j < 0 || i >= board.length || j >= board[0].length || word.charAt(wordIndex) != board[i][j])
            return false;

        char current = board[i][j];

        board[i][j] = '#';

        boolean found =    
               search(board, word, wordIndex+1, i+1, j) ||
               search(board, word, wordIndex+1, i-1, j) ||
               search(board, word, wordIndex+1, i, j+1) ||
               search(board, word, wordIndex+1, i, j-1);

        board[i][j] = current;

        return found;


    }

    
}
