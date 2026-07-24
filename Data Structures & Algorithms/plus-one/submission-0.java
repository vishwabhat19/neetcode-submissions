class Solution {
    public int[] plusOne(int[] digits) {
        for(int i=digits.length-1;i>=0;i--) {
            int temp = digits[i];
            if (temp < 9) {
                digits[i] = digits[i] + 1;
                return digits;
            }
            else {
                digits[i] = 0;
            }
        }
        int result[] = new int[digits.length+1];
        for(int i=0;i<digits.length;i++) {
            result[i+1] = digits[i];
        }
        result[0] = 1;
        return result;

    }
}
