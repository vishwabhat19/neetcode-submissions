class Solution {
    
    public String longestPalindrome(String s) {
        if (s == null || s.length() == 0) return "";
        int n = s.length();
        String result = "";
        int maxLength = Integer.MIN_VALUE;
        Boolean [][] dp = new Boolean[n][n];
        for(int i=0;i<n;i++) {
            for(int j=i;j<n;j++) {
                if (isPalindrome(s, i, j, dp) && (j - i) > maxLength) {
                    int size = j - i;
                    if (size > maxLength) {
                        maxLength = size;
                        result = s.substring(i,j+1);
                    }
                }
            }
        }

        return result;

    }

    boolean isPalindrome(String s, int i, int j, Boolean dp[][]) {
        if (i > j) return true;

        if (dp[i][j] != null && dp[i][j]) {
            return true;
        }

        if (s.charAt(i) == s.charAt(j)) {
            dp[i][j] = isPalindrome(s, i+1, j-1, dp);
        }

        else {
            dp[i][j] = false;
        }

        return dp[i][j];
    }
}
