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
        for(int i=0;i<32;i++) {
            if ((n & (1 << i)) != 0) c++;
        }
        return c;
    }
}
