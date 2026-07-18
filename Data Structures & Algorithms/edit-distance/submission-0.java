class Solution {
    public int minDistance(String word1, String word2) {
        Integer dp[][] = new Integer[word1.length() + 1][word2.length() + 1];
        return solve(word1, word2, 0, 0, dp);
    }

    int solve(String word1, String word2, int i, int j, Integer dp[][]) {
        if (i == word1.length()) return word2.length() - j;

        if (j == word2.length()) return word1.length() - i;

        if (dp[i][j] != null) return dp[i][j];

        if (word1.charAt(i) == word2.charAt(j)) return solve(word1, word2, i+1, j+1, dp);

        int insertOp  = solve(word1, word2, i, j+1, dp);
        int deleteOp  = solve(word1, word2, i+1, j, dp);
        int replaceOp = solve(word1, word2, i+1, j+1, dp);

        int min = Math.min(insertOp, Math.min(deleteOp, replaceOp));

        dp[i][j] = (1 + min);

        return 1 + min;
        
    }
}
