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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return dfs(root, p.val, q.val);
    }

    private TreeNode dfs(TreeNode curr, int p, int q) {
        if (curr == null) {
            return null;
        }

        int c = curr.val;

        if (c == p || c == q || (c < p && c > q) || (c > p && c < q)) {
            return curr;
        } else if (c < p && c < q) {
            return dfs(curr.right, p, q);
        } else {
            return dfs(curr.left, p, q);
        }
    }
}
