
class Solution {
    public int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) return -1;
        if (nums.length == 1 && nums[0]!=target) return -1;
        int left = 0;
        int right = nums.length - 1;
        int mid = left + (right - left)/2;
        while (left < right) {
            if (nums[mid] > nums[right]) {
                //Right side is unsorted
                left = mid + 1;
            }
            else {
                right = mid;
            }

            mid = left + (right - left)/2;
        }

        int pivot = mid;

        //Find in first half

        left = 0;
        right = pivot-1;
        mid = left + (right - left)/2;
        while(left <= right) {
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }

        //Find in second half
        left = pivot;
        right = nums.length - 1;
        mid = left + (right - left)/2;

        while(left <=right) {
            if (target == nums[mid]) return mid;
            if (target < nums[mid]) {
                right = mid - 1;
            }
            else {
                left = mid + 1;
            }
            mid = left + (right - left)/2;
        }
        
        return -1;

    }


}
