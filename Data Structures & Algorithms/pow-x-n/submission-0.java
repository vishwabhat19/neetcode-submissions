class Solution {
    public double myPow(double x, int n) {
        long N = n;

        //Handle negative exponent
        if (N < 0) {
            x = 1/x;
            N = -N;
        }

        return binaryPow(x, N);
    }

    double binaryPow(double x, long n) {
        if (n == 0) return 1.0;

        double halfPow = binaryPow(x, n/2);

        if (n % 2 == 0) {
            return halfPow * halfPow;
        }
        else {
            return halfPow * halfPow * x;
        }
    }
}
