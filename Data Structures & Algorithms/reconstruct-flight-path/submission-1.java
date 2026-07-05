class Solution {
    List<String> result = new ArrayList<>();
    Map<String, PriorityQueue<String>> map = new HashMap<>();
    public List<String> findItinerary(List<List<String>> tickets) {
        for(List<String> ticket : tickets) {
            map.computeIfAbsent(ticket.get(0), k -> new PriorityQueue()).offer(ticket.get(1));
        }

        dfs("JFK");

        return result;
    }

    void dfs(String airport) {
        PriorityQueue<String> destinations = map.get(airport);

        while (destinations!=null && !destinations.isEmpty()) {
            String next = destinations.poll();
            dfs(next);
        }

        result.addFirst(airport);
    }
}
