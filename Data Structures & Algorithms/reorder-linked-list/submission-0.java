/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public void reorderList(ListNode head) {
        if (head.next == null) { return; }

        Map<Integer,ListNode> map = new HashMap<>();

        ListNode curr = head;
        int i = 0;

        while (curr != null) {
            map.put(i, curr);
            curr = curr.next;
            i++;
        }

        curr = head;
        i--;
        ListNode temp = curr;

        while (temp != map.get(i)) {
            temp = curr.next;
            curr.next = map.get(i);
            curr = curr.next;

            if (temp == map.get(i)) { break; }
            i--;

            curr.next = temp;
            curr = curr.next;
        }

        curr.next = null;
    }
}
