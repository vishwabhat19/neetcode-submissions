class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int num : nums) set.add(num);

        int length = 0;
        
        for(int i=0;i<nums.length;i++) {
            if (set.contains(nums[i] - 1)) continue;
            length = Math.max(length, solve(nums[i], set, nums));
        }

        return length;
    }

    public int solve(int current, Set<Integer> set, int[] nums) {
        int length = 1;
        current++;
        while(set.contains(current)) {
            length++;
            current++;
        }
        return length;
    }
}
