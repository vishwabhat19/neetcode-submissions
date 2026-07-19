class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int paddedNums[] = new int[n+2];
        paddedNums[0] = 1;
        paddedNums[n+1] = 1;
        Integer[][] dp = new Integer[n+2][n+2];
        for(int i=1;i<n+1;i++) {
            paddedNums[i] = nums[i-1];
        }
        return solve(paddedNums, 1, n, dp);
    }

    int solve(int[] paddedNums, int left, int right, Integer[][] dp) {
        if (left > right) return 0;

        if (dp[left][right] != null) return dp[left][right];

        int max = 0;

        for(int k=left; k<= right; k++) {
            int leftCoins = solve(paddedNums, left, k-1, dp);
            int rightCoins = solve(paddedNums, k+1, right, dp);
            int centreCoins = paddedNums[left-1] * paddedNums[k] * paddedNums[right+1];
            int total = leftCoins + rightCoins + centreCoins;
            max = Math.max(max, total);
        }

        dp[left][right] = max;
        return max; 

    }
}
