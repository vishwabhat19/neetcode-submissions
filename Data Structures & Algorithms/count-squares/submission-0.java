class CountSquares {
    Map<Integer, Map<Integer,Integer>> map;
    List<int[]> points;

    public CountSquares() {
        map = new HashMap<>();
        points = new ArrayList<>();
    }
    
    public void add(int[] point) {
        int x = point[0];
        int y = point[1];
        map.putIfAbsent(x, new HashMap<>());
        Map<Integer, Integer> yMap = map.get(x);
        yMap.put(y, yMap.getOrDefault(y, 0) + 1);
        points.add(point);
    }
    
    public int count(int[] point) {
        int x1 = point[0];
        int y1 = point[1];
        int totalSquares = 0;
        for(int[] p : points) {
            int x2 = p[0];
            int y2 = p[1];
            if ((x1==x2) || Math.abs(x1-x2) != Math.abs(y1-y2)) {
                continue;
            }
            if (map.containsKey(x1) && map.get(x1).containsKey(y2) && map.containsKey(x2) && map.get(x2).containsKey(y1)) {
                int c3Count = map.get(x1).get(y2);
                int c4Count = map.get(x2).get(y1);
                totalSquares = totalSquares + (c3Count * c4Count);
            }
        }
        return totalSquares;
    }
}
