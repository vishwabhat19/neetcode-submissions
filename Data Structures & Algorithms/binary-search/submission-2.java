class Solution {
    public int search(int[] nums, int target) {
        if (nums.length == 0) return -1;
        if (nums.length == 1 && nums[0]!= target) return -1;
        if (nums.length == 1 && nums[0]== target) return 0;

        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;

        while(left <= right) {
            if (target == nums[mid]) return mid;
            if (target > nums[mid]) {
                left = mid + 1;
            }
            else{
                right = mid - 1;
            }
            mid = left + (right - left)/2;
        }
        return -1;

    }
}
