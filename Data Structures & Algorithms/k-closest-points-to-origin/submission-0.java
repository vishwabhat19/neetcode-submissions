class Solution {
    record Coordinate (int x, int y, Double distance) {}
    public int[][] kClosest(int[][] points, int k) {
       Queue<Coordinate> maxHeap = new PriorityQueue<>((a,b) -> Double.compare(b.distance, a.distance));
       for(int[] point : points) {
        int x = point[0];
        int y = point[1];
        double distance = Math.pow(x, 2) + Math.pow(y, 2);
        maxHeap.offer(new Coordinate(x, y, distance));
        if (maxHeap.size() > k) maxHeap.poll();
       }
        int result[][] = new int[k][2];
        for(int i=0;i<k;i++) {
            Coordinate point = maxHeap.poll();
            result[i][0] = point.x;
            result[i][1] = point.y;
        }
        return result;
        
       }



    }

    

