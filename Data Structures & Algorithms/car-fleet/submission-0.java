class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        Stack<Double> stack = new Stack<>();
        int n = position.length;
        double cars[][] = new double[n][2];
        
        for(int i=0;i<n;i++) {
            cars[i][0] = position[i];
            cars[i][1] = speed[i];
        }

        Arrays.sort(cars, (a, b) -> Double.compare(a[0], b[0]));

        for (int i=0;i<n;i++) {
            double currentTime = (target - cars[i][0]) / cars[i][1];

            // Remove Non bottle neck values
            while(!stack.isEmpty() && stack.peek() <= currentTime) {
                stack.pop();
            }

            stack.push(currentTime);

        }

        return stack.size();

        
    }
}
