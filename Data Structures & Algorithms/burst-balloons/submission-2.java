class Solution {
    public int maxCoins(int[] nums) {
        int n = nums.length;
        int[] paddedNums = new int[n+2];
        paddedNums[0] = 1;
        paddedNums[n+1] = 1;
        for(int i = 1;i<=n;i++) {
            paddedNums[i] = nums[i-1];
        }
        int left = 1;
        int right = n;
        Integer[][] dp = new Integer[n+2][n+2];
        return solve(paddedNums, left, right, dp);
    }

    int solve(int[] paddedNums, int left, int right, Integer[][] dp) {
        if (left > right) return 0;

        int max = 0;

        if (dp[left][right] != null) return dp[left][right];

        for(int i=left;i<=right;i++) {
            int leftCoins = solve(paddedNums, left, i-1, dp);
            int rightCoins = solve(paddedNums, i+1, right, dp);
            int centreCoins = paddedNums[left - 1] * paddedNums[i] * paddedNums[right+1];
            int total = leftCoins + rightCoins + centreCoins;
            max = Math.max(max, total);
        }

        dp[left][right] = max;
        return max;
    }
}
