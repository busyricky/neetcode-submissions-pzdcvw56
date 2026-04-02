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
        if (subRoot == null) {
            return true;
        } else if (root == null) {
            return false;
        }

        boolean test = false;
        if (root.val == subRoot.val) {
            test = sameTree(root, subRoot);
        }

        return test || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);
    }

    private boolean sameTree(TreeNode root, TreeNode subRoot) {
        if (root == null && subRoot == null) {
            return true;
        } else if (root == null || subRoot == null) {
            return false;
        } else if (root.val == subRoot.val) {
            return sameTree(root.left, subRoot.left) && sameTree(root.right, subRoot.right);
        } else {
            return false;
        }
    }
}
