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

        ListNode prevHead = new ListNode(1,head);
        ListNode slow = prevHead, fast = prevHead;

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        //reverse second half
        ListNode curr = slow.next, prev = null;
        slow.next = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;

            prev = curr;
            curr = temp;
        }
        
        ListNode first = head;
        ListNode second = prev;

        while (second != null) {
            ListNode temp = first.next;
            ListNode temp2 = second.next;

            first.next = second;
            second.next = temp;

            first = temp;
            second = temp2;
        }

    }
}
