class Solution {
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) return 0;
        Set<Integer> set = new HashSet<>();
        for(int num : nums) {
            set.add(num);
        }
        int max = 0;

        for(int i=0;i<nums.length;i++) {
            int current = nums[i];
            if (set.contains(current - 1)) continue;
            max = Math.max(max, solve(set, current));
        }

        return max+1;
    }

    int solve(Set<Integer> set, int current) {
        int length = 0;
        current++;
        while (set.contains(current)) {
            length++;
            current++;
        }
        return length;
    }
}
