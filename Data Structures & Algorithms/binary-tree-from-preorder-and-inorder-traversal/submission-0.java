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
    int preorderindex = 0;
    Map<Integer, Integer> map;


    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for(int i=0;i<inorder.length;i++) {
            map.put(inorder[i], i);
        }
        return buildTree(preorder, 0, inorder.length-1);
    }

    public TreeNode buildTree(int[] preorder, int left, int right) {
        if (left > right) return null;

        int rootValue = preorder[preorderindex++];
        TreeNode root = new TreeNode(rootValue);

        int inorderindex = map.get(rootValue);

        root.left = buildTree(preorder, left, inorderindex - 1);

        root.right = buildTree(preorder, inorderindex + 1, right);

        return root;

    }
}
