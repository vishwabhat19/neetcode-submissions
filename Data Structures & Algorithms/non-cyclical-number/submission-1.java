class Solution {
    public boolean isHappy(int n) {
        Set<Integer> set = new HashSet<>();
        while(n!=1 && !set.contains(n)) {
            set.add(n);
            n = sumOfSquares(n);
        }
        return n == 1;
    }

    public int sumOfSquares(int n) {
        int sum = 0;
        while(n>0) {
            int digit = n % 10;
            sum+=Math.pow(digit, 2);
            n = n / 10;
        }
        return sum;
    }
}
