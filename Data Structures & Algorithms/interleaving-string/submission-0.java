class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {

        if (s1.length() + s2.length() != s3.length()) return false;
        Boolean[][] dp = new Boolean[s1.length() + 1][s2.length() + 1];
        return solve(s1, s2, s3, 0, 0, 0, dp);
    }

    boolean solve(String s1, String s2, String s3, int i, int j, int k, Boolean[][] dp) {

        if (k == s3.length()) return true;

        if (dp[i][j]!=null) return dp[i][j];

        boolean path1 = false;

        boolean path2 = false;

        if (i < s1.length() && s1.charAt(i) == s3.charAt(k)) path1 = solve(s1, s2, s3, i+1, j, k+1, dp);

        if (j < s2.length() && s2.charAt(j) == s3.charAt(k)) path2 = solve(s1, s2, s3, i, j+1, k+1, dp);

        dp[i][j] = path1 || path2;
        
        return (path1 || path2);


    }
}
