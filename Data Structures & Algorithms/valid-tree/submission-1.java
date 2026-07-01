class Solution {
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        int[] parents = new int[n];
        for(int i=0;i<n;i++) {
            parents[i] = i;
        }

        for(int[] edge : edges) {
            int rootX = find(parents, edge[0]);
            int rootY = find(parents, edge[1]);

            if (rootX == rootY) return false;

            parents[rootX] = rootY;
        }

        return true;
    }

    public int find(int[] parents, int i) {
        if (parents[i] == i) return i;
        return find(parents, parents[i]);
    }
}
