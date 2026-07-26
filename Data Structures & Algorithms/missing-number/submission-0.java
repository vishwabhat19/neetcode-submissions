class Solution {
    public int missingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n*(n+1)/2;
        int actualSum = 0;
        for(int num : nums) {
            actualSum += num;
        }
        if (actualSum == expectedSum) return 0;
        return (expectedSum - actualSum);
    }
}
