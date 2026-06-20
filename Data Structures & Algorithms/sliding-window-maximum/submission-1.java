class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        Deque<Integer> dq = new ArrayDeque<>();
        int result[] = new int[nums.length - k + 1];
        int index = 0;
        for(int i=0;i<nums.length;i++) {
            //Remove elements outside the current window
            //from the left of the dq i.e front of the dq
            while(!dq.isEmpty() && dq.peekFirst() <= i - k) {
                dq.pollFirst();
            }


            //Before adding a new element to back or right of the queue
            //remove all elements that are smaller than it.
            //Our aim is that the largest element must be at the front of the
            //queue
            while(!dq.isEmpty() && nums[dq.peekLast()] <= nums[i]) {
                dq.pollLast();
            }

            //Add the current index
            dq.offerLast(i);

            //Check if window is formed
            if (i >= k - 1) {
                result[index++] = nums[dq.peekFirst()];
            }
        }
        return result;
    }
}
