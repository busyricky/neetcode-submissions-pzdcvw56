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
    int pIdx = 0;
    Map<Integer, Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < preorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int[] inorder, int start, int end) {
        if (start > end || pIdx >= preorder.length) {
            return null;
        }

        int curr = preorder[pIdx];
        int currIdx = map.get(curr);

        pIdx++;

        TreeNode node = new TreeNode(curr);
        

        node.left = helper(preorder, inorder, start, currIdx - 1);
        node.right = helper(preorder, inorder, currIdx + 1, end);

        return node;
    }
}
