class Solution {
    public double myPow(double x, int n) {
        if (n == 1) return x;
        if (n == 0) return 1;
        double result = pow(x, n);
        if (n < 0) {
            result = 1/result;
        }
        return result;
    }

    double pow(double x, int n) {
        if (n == 0) return 1;
        double half = pow(x, n/2);
        if (n % 2 == 0) {
            return half * half;
        }
        else {
            return half * half * x;
        }
    }
}
