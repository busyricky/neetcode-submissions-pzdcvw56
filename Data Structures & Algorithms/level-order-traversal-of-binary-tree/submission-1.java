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
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<List<Integer>> resp = new ArrayList<>();

        if (root != null) {
            qu.add(root);
        }

        while (!qu.isEmpty()) {
            int levelSize = qu.size();
            List<Integer> level = new ArrayList<>();

            for (int i = 0; i < levelSize; i++) {
                TreeNode curr = qu.poll();

                level.add(curr.val);

                if (curr.left != null) {
                    qu.add(curr.left);
                }
                if (curr.right != null) {
                    qu.add(curr.right);
                }
            }

            if (level.size() > 0) {
                resp.add(level);
            }

        }

        return resp;
    }
}
