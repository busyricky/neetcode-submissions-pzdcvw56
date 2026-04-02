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
    public int kthSmallest(TreeNode root, int k) {
        return dfs(root, k, new int[]{1});
    }

    private int dfs(TreeNode root, int k, int[] counter) {
        if (root == null) { return -1; }

        int resp = dfs(root.left, k, counter);
        if (resp != -1) { return resp; }

        if (counter[0] == k) { return root.val; }

        counter[0]++;

        return dfs(root.right, k, counter);
    }
}
