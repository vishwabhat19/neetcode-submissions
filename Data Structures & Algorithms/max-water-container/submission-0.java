class Solution {
    public int maxArea(int[] heights) {
        int max = Integer.MIN_VALUE;
        int left = 0;
        int right = heights.length - 1;
        while(left < right) {
            int area = Math.min(heights[left], heights[right]) * (right-left);
            max = Math.max(max, area);
            if (heights[left] < heights[right]) {
                left++;
            }
            else if (heights[left] > heights[right]) {
                right--;
            }
            else {
                left++;
                right--;
            }
        }
        return max;
    }
}
