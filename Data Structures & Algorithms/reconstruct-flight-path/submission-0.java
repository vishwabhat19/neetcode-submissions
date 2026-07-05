class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {
        List<String> result = new ArrayList<>();
        Map<String, PriorityQueue<String>> adj = new HashMap<>();
        for(List<String> ticket : tickets) {
            String from = ticket.get(0);
            String to = ticket.get(1);
            adj.computeIfAbsent(from, k -> new PriorityQueue<>()).offer(to);
        }

        dfs("JFK", result, adj);

        return result;
    }

    void dfs(String airport, List<String> result, Map<String, PriorityQueue<String>> adj) {
        PriorityQueue<String> destinations = adj.get(airport);

        while(destinations != null && !destinations.isEmpty()) {
            String nextCall = destinations.poll();
            dfs(nextCall, result, adj);
        }

        result.addFirst(airport);
    }
}
