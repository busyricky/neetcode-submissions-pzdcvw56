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
    int max;

    public int diameterOfBinaryTree(TreeNode root) {
        if (root == null) { return 0; }

        int leftH = heightHelper(root.left);
        int rightH = heightHelper(root.right);

        return Math.max(max, leftH + rightH);
    }

    private int heightHelper(TreeNode root) {
        if (root == null) { return 0; }

        int leftH = heightHelper(root.left);
        int rightH = heightHelper(root.right);

        max = Math.max(max, leftH + rightH);

        return 1 + Math.max(leftH, rightH);
    }
}
