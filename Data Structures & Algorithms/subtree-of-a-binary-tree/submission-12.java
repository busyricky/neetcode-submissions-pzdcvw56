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

            if (curr.val == subRoot.val) {
                if (dfs(curr, subRoot)) {
                    return true;
                }
            }

            if (curr.left != null) {
                qu.offer(curr.left);
            }

            if (curr.right != null) {
                qu.offer(curr.right);
            }
        }

        return false;
    }

    private boolean dfs(TreeNode root, TreeNode subroot) {
        if (root == null && subroot == null) {
            return true;
        } else if (root == null || subroot == null || subroot.val != root.val) {
            return false;
        } else {
            return dfs(root.left, subroot.left) && dfs(root.right, subroot.right);
        }
    }
}
