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

class Solution {
    public int goodNodes(TreeNode root) {
        return dfs(root, root.val);

    }

    private int dfs(TreeNode node, int max) {
        // Base case: if we hit an empty node, it contributes 0 good nodes
        if (node == null) return 0;

        int count = 0;

        // If the current node is greater than or equal to the maximum seen on this path
        if (node.val >= max) {
            count++; // It's a good node!
            max = node.val; // Update the maximum for our children
        }

        // Add the good nodes found in the left and right subtrees
        count = count + dfs(node.left, max);
        count = count + dfs(node.right, max);

        return count;
    }
}
