class Solution {
    public boolean isMatch(String s, String p) {
        return solve(s, p, 0, 0);
    }

    boolean solve(String s, String p, int i, int j) {
        if (p.length() == j) {
            return (s.length() == i);
        }

        boolean prevCharMatch = (i < s.length()) && (s.charAt(i) == p.charAt(j) || p.charAt(j) == '.');

        if ((j+1) < p.length() && p.charAt(j+1) == '*') {
            boolean takeAsterisk = prevCharMatch && solve(s, p, i+1, j);
            boolean dontTaskAsterisk = solve(s, p, i, j+2);
            return takeAsterisk || dontTaskAsterisk;
        }
        else {
            return prevCharMatch && solve(s, p, i+1, j+1);
        }


    }
}
