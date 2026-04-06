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
    int preOrderIdx = 0;
    Map<Integer,Integer> map;

    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();

        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }

        return helper(preorder, 0, inorder.length - 1);
    }

    private TreeNode helper(int[] preorder, int start, int end) {
        if (start > end) {
            return null;
        }

        // int inOrderIdx = map.get();

        int curr = preorder[preOrderIdx];
        TreeNode root = new TreeNode(curr);
        preOrderIdx++;

        root.left = helper(preorder, start, map.get(curr) - 1);
        root.right = helper(preorder, map.get(curr) + 1, end);
        
        return root;
    }
}
