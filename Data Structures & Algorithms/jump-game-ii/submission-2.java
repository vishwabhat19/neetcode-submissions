class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n <= 1) return 0;
        int l = 0, r = 0, jumps = 0;
        while(r < n-1) {
            int furthest = 0;
            for(int i=l;i<=r;i++) {
                furthest = Math.max(furthest, i + nums[i]);
            }
            l = r+1;
            r = furthest;
            jumps++;
        }
        return jumps;
    }
}
