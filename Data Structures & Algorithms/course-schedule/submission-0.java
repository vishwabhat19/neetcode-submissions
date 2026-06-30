class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<List<Integer>> adjList = new ArrayList();
        for(int i=0;i<numCourses;i++) {
            adjList.add(new ArrayList());
        }

        int[] indegree = new int[numCourses];

        for(int[] pre : prerequisites) {
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
            int currentNode = q.poll();
            list.add(currentNode);

            for(int neighbor : adjList.get(currentNode)) {
                indegree[neighbor]--;
                if (indegree[neighbor] == 0) {
                    q.offer(neighbor);
                }
            }
        }

        return list.size() == numCourses;


    }
}
