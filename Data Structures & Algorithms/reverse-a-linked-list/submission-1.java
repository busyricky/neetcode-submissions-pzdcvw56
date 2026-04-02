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
    public ListNode reverseList(ListNode head) {
        if (head == null) { return null; }

        ListNode curr = head, prev = null, next = curr.next, temp = curr.next;

        while (temp != null) {
            curr.next = prev;
            prev = curr;
            temp = next.next;
            next.next = curr;
            curr = next;
            next = temp;
        }

        return curr;
    }
}
