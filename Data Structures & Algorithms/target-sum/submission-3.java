class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        Map<String, Integer> dp = new HashMap<>();
        return solve(nums, target, 0, dp);
    }

    int solve(int[] nums, int target, int i, Map<String, Integer> dp) {
        if (target == 0 && i == nums.length) return 1;

        if (i >= nums.length) return 0;

        String key = i +","+ target;

        if (dp.containsKey(key)) return dp.get(key);

        int plus = solve(nums, target - nums[i], i+1, dp);
        int minus = solve(nums, target + nums[i], i+1, dp);

        dp.put(key, (plus+minus));

        return plus + minus;
    }
}
