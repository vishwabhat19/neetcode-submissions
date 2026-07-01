class Solution {
    /*
To determine if a graph is a valid tree, we need to verify two strict mathematical 
properties that define a tree structure:The graph must be fully connected: 
Every node must be reachable from any other node.The graph must contain NO cycles: 
There should be no loops or alternative paths between any two nodes.
There is a brilliant math shortcut we can use here. 
For any valid tree with $n$ nodes, it must have exactly $n - 1$ edges.
If it has fewer than $n - 1$ edges, it is guaranteed to be disconnected.
If it has more than $n - 1$ edges, it is guaranteed to contain a cycle.
By checking edges.length == n - 1 right at the beginning, we eliminate half the problem. 
Then, we just need to verify that the graph is 
fully connected using either Breadth-First Search (BFS) or a Union-Find (Disjoint Set) data structure.
*/

    public boolean validTree(int n, int[][] edges) {
        if (edges.length!=n-1) return false;

        int parent[] = new int[n];

        for(int i=0;i<n;i++) {
            parent[i] = i;
        }

        for(int[] edge : edges) {
            int x = edge[0];
            int y = edge[1];
            int parentX = find(parent, x);
            int parentY = find(parent, y);

            if (parentX == parentY) {
                //They are already connected. Adding another edge makes it a cycle.
                return false;
            }
            else {
                parent[parentX] = parentY;
            }
        }
        return true;
    }

    public int find(int[] parent, int i) {
        if (parent[i] == i) return i; //i is the ultimate boss of itself
        else { //i is not the ultimate boss of itself. It has some other boss. so recursively find its parent
            parent[i] = find(parent, parent[i]); 
        }
        return parent[i];
    }
}
