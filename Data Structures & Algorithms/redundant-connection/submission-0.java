class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i=0;i<edges.length;i++) {
            parent[i] = i;
        }

        int[] result = new int[2];

        for(int[] edge : edges) {
            int parentX = find(parent, edge[0]);
            int parentY = find(parent, edge[1]);

            if (parentX != parentY) {
                parent[parentX] = parentY;
            }
            else {
                result[0] = edge[0];
                result[1] = edge[1];
            }
        }

        return result;
    }

    public int find(int parent[], int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}
