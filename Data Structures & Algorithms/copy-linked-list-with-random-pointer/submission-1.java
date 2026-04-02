/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node newCurr = null, curr = head;
        Map<Node,Node> map = new HashMap<>();

        while (curr != null) {
            newCurr = new Node(curr.val);
            map.put(curr, newCurr);
            curr = curr.next;
        }

        curr = head;
        while (curr != null) {
            newCurr = map.get(curr);
            if (curr.random != null) {
                newCurr.random = map.get(curr.random);
            }
            curr = curr.next;
        }

        Node newHead = map.get(head);
        newCurr = newHead;
        curr = head;
        while (curr != null) {
            if (curr.next != null) {
                newCurr.next = map.get(curr.next);
            }
            newCurr = newCurr.next;
            curr = curr.next;
        }

        return newHead;
    }
}
