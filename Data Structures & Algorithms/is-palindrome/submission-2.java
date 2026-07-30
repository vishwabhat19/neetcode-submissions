class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        char[] arr = s.toCharArray();

        int left = 0;
        int right = s.length() - 1;
        while (left < right) {
            if (!isValid(arr[left])) {
                left++;
                continue;
            }
            if (!isValid(arr[right])) {
                right--;
                continue;
            }
            if (arr[left] == arr[right]) {
                left++;
                right--;
            }
            else {
                return false;
            }
        }
        return true;
    }

    boolean isValid(char c) {
        if (c >= '0' && c <= '9') return true;
        if (c >= 'a' && c <= 'z') return true;
        return false;
    }
}
