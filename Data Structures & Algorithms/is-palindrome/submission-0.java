class Solution {
    public boolean isPalindrome(String s) {
        if (s.length() == 0) return false;
        if (s.length() == 1) return true;
        s = s.toLowerCase();
        int left = 0;
        int right = s.length() - 1;
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!isValid(leftChar)) {
                left++;
                continue;
            }
            if (!isValid(rightChar)) {
                right--;
                continue;
            }
            if (s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;

    }

    public static boolean isValid(char c) {
        if ((c >= '0' && c <= '9') || (c >= 'a' && c <= 'z')) return true;
        return false;
    }
}
