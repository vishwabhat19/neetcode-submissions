class Solution {
    public int lastStoneWeight(int[] stones) {
        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> (b-a));
        for(int stone : stones) {
            maxHeap.offer(stone);
        }

        while(maxHeap.size() > 1) {
            int firstHeavyStone = maxHeap.poll();
            int secondHeavyStone = maxHeap.poll();

            if (firstHeavyStone == secondHeavyStone) continue;

            maxHeap.offer(firstHeavyStone - secondHeavyStone);
        }

        return (maxHeap.size() == 0) ? 0 : maxHeap.peek();
    }
}
