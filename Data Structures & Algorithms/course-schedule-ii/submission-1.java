class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList<>();
        int[] indegree = new int[numCourses];
        for(int i=0;i<numCourses;i++) {
            adjList.add(new ArrayList());
        }

        for(int pre[] : prerequisites) {
            int from = pre[1];
            int to = pre[0];
            adjList.get(from).add(to);
            indegree[to]++;
        }

        Queue<Integer> q = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        for(int i=0;i<numCourses;i++) {
            if (indegree[i] == 0) q.offer(i);
        }

        while(!q.isEmpty()) {
            int current = q.poll();
            list.add(current);
            for(int neighbor : adjList.get(current)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) q.offer(neighbor);
            }
        }

        int result[] = new int[numCourses];

        if (list.size() != numCourses) return new int[0];

        for(int i=0;i<numCourses;i++) {
            result[i] = list.get(i);
        }

        return result;
    }
}
