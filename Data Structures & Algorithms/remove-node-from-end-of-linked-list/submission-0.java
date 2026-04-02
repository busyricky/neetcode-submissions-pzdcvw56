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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int sz = 0;

        ListNode curr = head;

        while (curr != null) {
            sz++;
            curr = curr.next;
        }

        int i = 0;
        curr = head;
        ListNode prev = head;

        if (sz == n) {
            return head.next;
        }

        while (curr != null) {
            if (n == sz-i) {
                prev.next = curr.next;
                break;
            }
            i++;
            prev = curr;
            curr = curr.next;
        }

        return head;
    }
}
