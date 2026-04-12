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
    class CNode {
        TreeNode node;
        int[] position;

        CNode(TreeNode node, int x, int y) {
            this.node = node;
            position = new int[]{x,y};
        }
    }

    public List<List<Integer>> verticalOrder(TreeNode root) {
        if (root == null) { return new ArrayList<>(); }

        Map<Integer, List<Integer>> map = new HashMap<>(); //column -> list

        Queue<CNode> qu = new LinkedList<>();
        qu.offer(new CNode(root, 0, 0));

        int minCol = 0, maxCol = 0;

        while (!qu.isEmpty()) {
            CNode curr = qu.poll();
            int row = curr.position[0], col = curr.position[1];
            minCol = Math.min(minCol, col);
            maxCol = Math.max(maxCol, col);

            if (map.containsKey(col)) {
                map.get(col).add(curr.node.val);
            } else {
                List<Integer> newList = new ArrayList<>();
                newList.add(curr.node.val);
                map.put(col, newList);
            }

            if (curr.node.left != null) {
                qu.offer(new CNode(curr.node.left, row + 1, col - 1));
            }

            if (curr.node.right != null) {
                qu.offer(new CNode(curr.node.right, row + 1, col + 1));
            }
        }

        //build response
        List<List<Integer>> resp = new ArrayList<>();
        for (int i = minCol; i <= maxCol; i++) {
            resp.add(map.get(i));
        }

        //return response
        return resp;
    }

}