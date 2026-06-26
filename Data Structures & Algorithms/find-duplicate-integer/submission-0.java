class Solution {
    public int findDuplicate(int[] nums) {
        for(int i=0;i<nums.length;i++) {
            int checkIndex = Math.abs(nums[i]);
            if (nums[checkIndex-1] < 0) return Math.abs(nums[i]);
            nums[checkIndex-1] = Math.abs(nums[checkIndex-1]) * -1;
        }
        return 0;
    }
}
