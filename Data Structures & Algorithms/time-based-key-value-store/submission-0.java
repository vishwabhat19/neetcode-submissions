class TimeMap {

    
        private Map<String, List<Node>> map;

        private class Node {
            String value;
            int timestamp;

             Node (String value, int timestamp) {
                this.value = value;
                this.timestamp = timestamp;
            }
        }

    

    public TimeMap() {
        map = new HashMap<>();
    }
    
    public void set(String key, String value, int timestamp) {
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Node>());
        }
       map.get(key).add(new Node(value, timestamp));
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) return "";
        return binarySearch(map.get(key), timestamp);
    }

    public static String binarySearch(List<Node> list, int target) {
        int left = 0;
        int right = list.size() - 1;
        int mid = left + (right - left)/2;
        String result = "";
        while(left <= right) {
            if (list.get(mid).timestamp == target) return list.get(mid).value;
            else if (list.get(mid).timestamp < target) {
                left = mid + 1;
                result = list.get(mid).value;
            }
            else {
                right = mid - 1;
            }
            mid = left + (right-left)/2;
        }

        return result;
        
    }
}
