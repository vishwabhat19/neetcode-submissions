/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        serialize(root, sb);
        return sb.toString();
    }

    private void serialize(TreeNode node, StringBuilder sb) {
        if (node == null) {
            sb.append("#,");
            return;
        }

        sb.append(node.val).append(",");
        serialize(node.left, sb);
        serialize(node.right, sb);

    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String nodes[] = data.split(",");
        Queue<String> q = new LinkedList<>(Arrays.asList(nodes));
        return deserialize(q);
    }

    private TreeNode deserialize(Queue<String> q) {
        String current = q.poll();

        if (current.equals("#")) {
            return null;
        }

        TreeNode root = new TreeNode(Integer.parseInt(current));

        root.left = deserialize(q);
        root.right = deserialize(q);

        return root;
    }
}
