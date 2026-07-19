class Solution {
    public int numDistinct(String s, String t) {
        Integer[][] dp = new Integer[s.length() + 1][t.length() + 1];
        return solve(s, t, 0, 0, dp);
    }

    int solve(String s, String t, int i, int j, Integer[][] dp) {
        if (t.length() == j) return 1;
        
        if (s.length() == i) return 0;

        if (dp[i][j] != null) return dp[i][j];
        int ways = 0;

        if (s.charAt(i) == t.charAt(j)) {
            ways += solve(s, t, i+1, j+1, dp);
        }

        ways += solve(s, t, i+1, j, dp);

        dp[i][j] = ways;

        return ways;
    }
}
