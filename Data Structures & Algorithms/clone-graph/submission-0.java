/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) return node;
        Map<Node, Node> originalDuplicateMap = new HashMap<>();
        return dfs(node, originalDuplicateMap);
    }

    public Node dfs(Node originalNode, Map<Node, Node> map) {

        if (map.containsKey(originalNode)) {
            return map.get(originalNode);
        }

        Node clone = new Node(originalNode.val);

        map.put(originalNode, clone);
        
        //Populate neighbors
        for (Node neighbor : originalNode.neighbors) {
            clone.neighbors.add(dfs(neighbor, map)); 
        }

        return clone;
    }


}