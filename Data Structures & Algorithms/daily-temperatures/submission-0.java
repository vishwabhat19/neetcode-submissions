class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Deque<Integer> stack = new ArrayDeque<>();
        int n = temperatures.length;
        int result[] = new int[n];
        result[n-1] = 0;
        stack.push(n-1);
        for(int i=n-2;i>=0;i--) {
            while(!stack.isEmpty() && temperatures[stack.peek()] <= temperatures[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                result[i] = 0;
            }
            else {
                result[i] = stack.peek() - i;
            }

            stack.push(i);
        }
        return result;
    }
}
