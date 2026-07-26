class Solution {
    public int[] countBits(int n) {
        int[] result = new int[n+1];
        for(int i=0;i<=n;i++) {
            result[i] = count(i);
        }
        return result;
    }

    public int count(int n) {
        int c = 0;
        while(n > 0) {
            n = n & (n-1);
            c++;
        }
        return c;
    }
}
