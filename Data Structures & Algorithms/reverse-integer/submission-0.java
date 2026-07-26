class Solution {
    public int reverse(int x) {
        int res = 0;
        int max = Integer.MAX_VALUE;
        int min = Integer.MIN_VALUE;
        while (x != 0) {
            int lastDigit = x % 10; //Pop last digit
            x = x / 10; // Drop last digit
            if (res > max/10 || ((res == max/10) && (lastDigit > max % 10))) {
                return 0;
            }
            if (res < min/10 || ((res == min/10) && (lastDigit < min % 10))) {
                return 0;
            }
            res = res * 10 + lastDigit;
        }
        return res;
    }
}
