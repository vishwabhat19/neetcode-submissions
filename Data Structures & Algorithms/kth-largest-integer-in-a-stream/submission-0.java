class KthLargest {

    Queue<Integer> q;
    int k;

    public KthLargest(int k, int[] nums) {
        this.q = new PriorityQueue<Integer>((a,b) -> (a-b));
        this.k = k;
        for(int n : nums) {
            this.add(n);
        }
        
    }
    
    public int add(int val) {
        q.offer(val);
        if (q.size() > k) {
            q.poll();
        }
        return q.peek();
    }
}
