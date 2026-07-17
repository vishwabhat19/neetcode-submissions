class Solution {
    public boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums) {
            sum+=num;
        }

        if (sum % 2 != 0) return false;

        int halfSum = sum/2;

        Boolean[][] dp = new Boolean[nums.length][halfSum + 1];

        return solve(nums, halfSum, 0, dp);
    }

    boolean solve(int[] nums, int remaining, int i, Boolean[][] dp) {
        if (remaining == 0) return true;

        if (i >= nums.length || remaining < 0) return false;

        if(dp[i][remaining] != null) {
            return dp[i][remaining];
        }

        boolean dontTake = solve(nums, remaining, i+1, dp);
            
        boolean take = solve(nums, remaining - nums[i], i+1, dp);

        dp[i][remaining] = dontTake || take;

        return dontTake || take;
        

    }
}
