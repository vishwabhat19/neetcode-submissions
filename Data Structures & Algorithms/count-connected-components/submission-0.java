class Solution {
    public int countComponents(int n, int[][] edges) {
        int parent[] = new int[n];
        int components = n;
        for(int i=0;i<n;i++) {
            parent[i] = i;
        }

        for(int edge[] : edges) {
            int rootX = find(parent, edge[0]);
            int rootY = find(parent, edge[1]);

            if (rootX != rootY) {
                parent[rootX] = rootY;
                components--;
            }
        }

        return components;
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) return i;
        parent[i] = find(parent, parent[i]);
        return parent[i];
    }
}
