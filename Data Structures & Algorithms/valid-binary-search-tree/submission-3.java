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
    public boolean isValidBST(TreeNode root) {
        return dfs(root, -1001, 1001);
    }

    private boolean dfs(TreeNode root, int min, int max) {
        if (root == null) {
            return true;
        }

        if (root.left != null && (root.val <= root.left.val || root.left.val <= min)) {
            return false;
        }

        if (root.right != null && (root.val >= root.right.val || root.right.val >= max)) {
            return false;
        }

        return dfs(root.left, min, root.val) && dfs(root.right, root.val, max);
    }
}
