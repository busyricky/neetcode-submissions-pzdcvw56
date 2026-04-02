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
    class Pair {
        TreeNode node;
        int level;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<Pair> qu = new LinkedList<>();
        List<List<Integer>> resp = new LinkedList<>();
        // boolean visited ????

        if (root != null) {
            qu.add(new Pair(root, 0));
        }

        while (!qu.isEmpty()) {
            Pair curr = qu.poll();
            if (resp.size() < curr.level + 1) {
                resp.add(new LinkedList<>(List.of(curr.node.val)));
            } else {
                resp.get(curr.level).add(curr.node.val);
            }

            if (curr.node.left != null) {
                qu.add(new Pair(curr.node.left, curr.level + 1));
            }
            if (curr.node.right != null) {
                qu.add(new Pair(curr.node.right, curr.level + 1));
            }
        }

        return resp;
    }
}
