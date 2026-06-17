class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap();
        for(int i=0;i<nums.length;i++) {
            map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
        }

        Queue<Map.Entry<Integer, Integer>> q = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());

        for(Map.Entry<Integer, Integer> entry : map.entrySet()) {
            q.offer(entry);
            if (q.size() > k) q.poll();
        }

        int result[] = new int[k];

        for(int i=0;i<k;i++) {
            result[i] = q.poll().getKey();
        }

        return result;
    }
}
