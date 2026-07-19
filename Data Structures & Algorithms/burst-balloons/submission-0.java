class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] paddedNums = new int[n+2];
        paddedNums[0] = 1;
        paddedNums[n+1] = 1;
        for(int i=1;i<n+1;i++) {
            paddedNums[i] = nums[i-1];
        }
        int[][] dp = new int[n+2][n+2];
        return solve(paddedNums, 1, n, dp);
    }

    int solve(int[] paddedNums, int left, int right, int[][] dp) {
        if (left > right) return 0;

        if (dp[left][right] != 0) return dp[left][right];

        int maxCoins = 0;

        for(int i=left;i<=right;i++) {
            int currentMax = paddedNums[left - 1] * paddedNums[i] * paddedNums[right + 1];
            int leftMax = solve(paddedNums, left, i-1, dp);
            int rightMax = solve(paddedNums, i+1, right, dp);
            int totalCoins = currentMax + leftMax + rightMax;
            maxCoins = Math.max(maxCoins, totalCoins);
        }

        dp[left][right] = maxCoins;
        return maxCoins;
    }
}
