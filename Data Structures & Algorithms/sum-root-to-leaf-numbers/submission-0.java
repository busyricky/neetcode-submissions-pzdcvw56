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
    List<Integer> list;

    public int sumNumbers(TreeNode root) {
        list = new ArrayList<>();
        
        dfs(root, 0);

        int resp = 0;

        for (int num : list) {
            resp += num;
        }

        return resp;
    }

    private void dfs(TreeNode node, int sum) {
        if (node == null) {
            return;
        }

        if (node.left == null && node.right == null) {
            list.add(sum*10 + node.val);
            return;
        }

        dfs(node.left, sum*10 + node.val);
        dfs(node.right, sum*10 + node.val);
    }
}