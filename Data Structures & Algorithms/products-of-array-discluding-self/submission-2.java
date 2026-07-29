class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] pp = new int[nums.length];
        int[] ap = new int[nums.length];
        int[] result = new int[nums.length];
        
        pp[0] = 1;
        ap[nums.length-1] = 1;
        for(int i=1;i<nums.length;i++) {
            pp[i] = pp[i-1] * nums[i-1];
        }

        for(int i=nums.length-2;i>=0;i--) {
            ap[i] = ap[i+1] * nums[i+1];
        }

        for(int i=0;i<nums.length;i++) {
            result[i] = ap[i] * pp[i];
        }

        return result;


    }
}  
