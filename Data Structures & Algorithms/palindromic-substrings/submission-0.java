class Solution {
    int result = 0;
    public int countSubstrings(String s) {
        if (s == null || s.length() == 0) return 0;
        for(int i=0;i<s.length();i++) {
            expandAndTrack(s, i, i);
            expandAndTrack(s, i, i+1);
        }
        return result;
    }

    void expandAndTrack(String s, int left, int right) {
        while(left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
            result++;
            left--;
            right++;
        }

        
    }
}
