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
        int level;
        TreeNode node;

        Pair(TreeNode node, int level) {
            this.node = node;
            this.level = level;
        }
    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (p.val == root.val || q.val == root.val) { return root; }

        Stack<Pair> stackP = new Stack<>(), stackQ = new Stack<>();
        TreeNode curr = root;
        int level = 0;

        while (curr.val != p.val) { //find p node
            stackP.push(new Pair(curr, level));
            if (p.val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            level++;
        }
        stackP.push(new Pair(curr, level));

        curr = root;
        level = 0;
        while (curr.val != q.val) { //find q node
            stackQ.push(new Pair(curr, level));
            if (q.val < curr.val) {
                curr = curr.left;
            } else {
                curr = curr.right;
            }
            level++;
        }
        stackQ.push(new Pair(curr, level));

        
        Pair lca = new Pair(root,0);
        Pair pn = null, qn = null;

        while(!stackP.isEmpty() && !stackQ.isEmpty()) {
            if (pn == null && qn == null) {
                pn = stackP.pop();
                qn = stackQ.pop();
            }
            if (pn.level < qn.level) {
                qn = stackQ.pop();
            } else if (pn.level > qn.level) {
                pn = stackP.pop();
            } else {    //levels are equal, compare
                if (qn.node.val == pn.node.val && qn.level > lca.level) {
                    return qn.node;
                } else {
                    qn = stackQ.pop();
                    pn = stackP.pop();
                }
            }
        }

        if (qn!= null && pn != null && qn.node.val == pn.node.val && qn.level > lca.level) {
            lca = qn;
        }

        return lca.node;
    }
}










