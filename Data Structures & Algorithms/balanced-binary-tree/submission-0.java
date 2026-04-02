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
    boolean resp = true;

    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        }

        height(root);

        return resp;
    }

    private int height(TreeNode root) {
        if (root == null) {
            return 0;
        }

        int leftH = height(root.left);
        int rightH = height(root.right);
        int diff = leftH - rightH;

        if (diff > 1 || diff < -1) {
            resp = false;
        }

        return 1 + Math.max(leftH, rightH);
    }
}
