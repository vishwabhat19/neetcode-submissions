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
        Map<Node, Node> map = new HashMap<>();
        Node clone = clone(node, map);
        return clone;
    }

    Node clone(Node original, Map<Node, Node> map) {
        if (original == null) return original;

        if (map.containsKey(original)) {
            return map.get(original);
        }

        Node clone = new Node(original.val);

        map.put(original, clone);

        for(Node neighbor : original.neighbors) {
            clone.neighbors.add(clone(neighbor, map));
        }

        return clone;

    }
}