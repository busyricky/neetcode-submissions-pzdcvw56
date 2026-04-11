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
    int max = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        dfs(root);

        return max;
    }

    private int dfs (TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = root.left == null ? 0 : 1 + dfs(root.left);
        int rightH = root.right == null ? 0 : 1 + dfs(root.right);

        // return Math.max(Math.max(leftH, rightH), leftH + rightH - 1);
        max = Math.max(max, leftH + rightH);

        return Math.max(leftH, rightH);
    }
}








