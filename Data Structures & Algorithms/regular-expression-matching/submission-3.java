class Solution {
    public boolean isMatch(String s, String p) {
        Boolean[][] dp = new Boolean[s.length() + 1][p.length() + 1];
        return solve(s, p, 0, 0, dp);
    }

    boolean solve(String s, String p, int i, int j, Boolean[][] dp) {
        if (p.length() == j) {
            return (s.length() == i);
        }

        if (dp[i][j] != null) return dp[i][j];

        boolean prevCharMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if ((j+1) < p.length() && p.charAt(j+1) == '*') {
            boolean takeAsterisk = prevCharMatch && solve(s, p, i+1, j, dp);
            boolean dontTaskAsterisk = solve(s, p, i, j+2, dp);
            dp[i][j] = takeAsterisk || dontTaskAsterisk;
            return takeAsterisk || dontTaskAsterisk;
        }
        else {
            dp[i][j] = prevCharMatch && solve(s, p, i+1, j+1, dp);
            return dp[i][j];
        }


    }
}
