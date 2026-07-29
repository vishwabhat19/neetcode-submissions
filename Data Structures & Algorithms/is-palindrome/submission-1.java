class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isValid(s.charAt(left))) {
                left++;
                continue;
            }
            if (!isValid(s.charAt(right))) {
                right--;
                continue;
            }
            else if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else return false;
        }
        return true;
    }

    boolean isValid(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }
}
