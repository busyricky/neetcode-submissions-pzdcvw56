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
    public List<Integer> rightSideView(TreeNode root) {
        Queue<TreeNode> qu = new LinkedList<>();
        List<Integer> list = new ArrayList<>();

        if (root != null) { qu.add(root); }

        while(!qu.isEmpty()) {
            int levelSize = qu.size();
            TreeNode curr = new TreeNode();
            
            for(int i = 0; i < levelSize; i++) {
                curr = qu.poll();

                if (curr.left != null) { qu.add(curr.left); }
                if (curr.right != null) { qu.add(curr.right); }
            }

            if (levelSize > 0) {
                list.add(curr.val);
            }
        }

        return list;
    }
}








