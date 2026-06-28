class Solution {
    public int findKthLargest(int[] nums, int k) {
        Queue<Integer> maxHeap = new PriorityQueue<Integer>((a,b) -> Integer.compare(b,a));

        for(int num : nums) {
            maxHeap.offer(num);
        }
        int result = 0;
        for(int i=0;i<k;i++) {
            if (i==k-1) {
                result = maxHeap.poll();
                break;
            }
            maxHeap.poll();
        }
        return result;
    }
}
