class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet();
        int length = 0;
        for(int num : nums) {
            set.add(num);
        }

        for(int i=0;i<nums.length;i++) {
            int current = nums[i];
            if (set.contains(current - 1)) continue;
            length = Math.max(length, solve(nums, current, set));
        }

        return length;
    }

    public static int solve(int nums[], int current, Set<Integer> set) {
        int length = 1;
        current = current + 1;
        while(set.contains(current)) {
            length++;
            current++;
        }
        return length;
    }
}
