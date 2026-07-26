class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] result = new int[nums.length];
        int[] pSum = new int[nums.length];
        pSum[0] = 1;
        int[] sSum = new int[nums.length];
        sSum[nums.length - 1] = 1;

        for(int i=1;i<nums.length;i++) {
            pSum[i] = pSum[i-1] * nums[i-1];
        }
        for(int i=nums.length-2;i>=0;i--) {
            sSum[i] = sSum[i+1] * nums[i+1];
        }

        for(int i=0;i<nums.length;i++) {
            result[i] = pSum[i] * sSum[i];
        }

        return result;
    }
}  
