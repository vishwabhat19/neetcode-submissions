class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    boolean solve(String s, String p, int i, int j) {
        if (j == p.length()) {
            return (i == s.length());
        }

        boolean firstCharMatched = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');
       
        if (j + 1 < p.length() && p.charAt(j+1) == '*') {
            boolean dontTake = solve(s, p, i, j+2);
            boolean take = firstCharMatched && solve(s,p,i+1, j);
            return dontTake || take;
        }
        else {
            return firstCharMatched && solve(s, p, i+1, j+1);
        }

    }
}
