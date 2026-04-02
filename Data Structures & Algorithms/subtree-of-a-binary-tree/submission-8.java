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
        Queue<TreeNode> qu = new LinkedList<>();

        qu.offer(root);

        while (!qu.isEmpty()) {
            TreeNode curr = qu.poll();

            if (curr.val == subRoot.val && checkSubtree(curr, subRoot)) {
                return true;
            } else {
                if (curr.left != null) { qu.offer(curr.left); }
                if (curr.right != null) { qu.offer(curr.right); }
            }
        }

        return false;
    }

    private boolean checkSubtree(TreeNode root, TreeNode subRoot) {
        if (root == null || subRoot == null) { 
            return subRoot == null && root == null ? true : false; 
        }

        if (root.val != subRoot.val) {
            return false;
        }

        return checkSubtree(root.left, subRoot.left) && checkSubtree(root.right, subRoot.right);

    }
}
