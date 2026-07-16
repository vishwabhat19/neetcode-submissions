class Solution {
    public int maxProduct(int[] nums) {
        int globalMax = nums[0];
        int currentMax = nums[0];
        int currentMin = nums[0];
        for(int i=1;i<nums.length;i++) {
            int previousMin = currentMin;
            currentMin = Math.min(nums[i], Math.min(nums[i] * currentMin, nums[i] * currentMax));
            currentMax = Math.max(nums[i], Math.max(nums[i] * previousMin, nums[i] * currentMax));
            globalMax = Math.max(globalMax, currentMax);
        }
        return globalMax;
    }
}
