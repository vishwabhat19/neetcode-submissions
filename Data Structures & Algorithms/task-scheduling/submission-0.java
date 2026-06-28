class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] freqMap = new int[26];
        for(char task : tasks) {
            freqMap[task - 'A']++;
        }

        Queue<Integer> maxHeap = new PriorityQueue<>((a,b) -> Integer.compare(b,a));

        for(int freq : freqMap) {
            if (freq > 0) maxHeap.offer(freq);
        } 

        Queue<int[]> cooler = new LinkedList<>();
        int time = 0;

        while(!maxHeap.isEmpty() || !cooler.isEmpty()) {
            time++;

            //Check if anything in cooler is ready
            if (!cooler.isEmpty() && cooler.peek()[1] == time) {
                maxHeap.offer(cooler.poll()[0]);
            }

            //Execute the highest frequency task available in the maxHeap
            if (!maxHeap.isEmpty()) {
                int remainingFreq = maxHeap.poll() - 1;

                if (remainingFreq > 0) {
                    cooler.offer(new int[]{remainingFreq, time + n + 1});
                }
            }
        }

        return time;
    }
}
