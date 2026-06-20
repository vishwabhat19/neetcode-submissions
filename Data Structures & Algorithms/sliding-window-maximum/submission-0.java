class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> result = new ArrayList();
        int left = 0;
        int right = k - 1;

        Queue<Integer> q = new PriorityQueue<>((a,b) -> (b - a));

        for(int i=0;i<k;i++) {
            q.offer(nums[i]);
        }

        while(right < nums.length) {
            result.add(q.peek());
            q.remove(nums[left]);
            left++;
            right++;
            if (right < nums.length) {
                q.offer(nums[right]);
            }
            
        }

        return result.stream().mapToInt(Integer::intValue).toArray();

    }
}
