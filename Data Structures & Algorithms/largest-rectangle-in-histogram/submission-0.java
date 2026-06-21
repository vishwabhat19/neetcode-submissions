class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> stack = new Stack<>();
        if (heights.length == 0) return 0;
        if (heights.length == 1) return (heights[0]);
        int maxArea= Integer.MIN_VALUE;
        stack.push(new int[]{heights[0], 0});

        for(int i=0;i<heights.length;i++) {
            int lastPoppedIndex = 0;
            int lastPoppedHeight = 0;
            boolean popped = false;

            while(!stack.isEmpty() && heights[i] < stack.peek()[0]) {
                lastPoppedIndex = stack.peek()[1];
                lastPoppedHeight = stack.peek()[0];
                maxArea = Math.max(maxArea, lastPoppedHeight * (i - lastPoppedIndex));
                stack.pop();
                popped = true;
            }

            if (popped) {
                stack.push(new int[]{heights[i], lastPoppedIndex});
            }
            else {
                stack.push(new int[]{heights[i], i});
            }
        }

        while(!stack.isEmpty()) {
            maxArea = Math.max(maxArea, (stack.peek()[0] * (heights.length - stack.peek()[1])));
            stack.pop();
        }

        return maxArea;
    }
}
