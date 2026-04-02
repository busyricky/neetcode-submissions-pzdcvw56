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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if (subRoot == null) { return true; }

        return helper(root, subRoot);
    }

    private boolean helper(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        }

        boolean test = false;
        if (root.val == subRoot.val) {
            test = helper2(root.left, subRoot.left) && helper2(root.right, subRoot.right);
        }

        return test || helper(root.left, subRoot) || helper(root.right, subRoot);
    }

    private boolean helper2(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null || root.val != subRoot.val) {
            return false;
        }

        return helper2(root.left, subRoot.left) && helper2(root.right, subRoot.right);
    }
}
