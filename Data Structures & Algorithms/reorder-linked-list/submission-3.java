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
        if (head == null) { return; }

        // find middle
        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy, slow = dummy;
        while (fast != null && fast.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        // reverse second half of list
        ListNode prev = null, curr = slow.next, temp = null;
        slow.next = null;
        while(curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        //reorder list using prev and head
        curr = head;
        while (prev != null && curr != null) {
            temp = curr.next;
            curr.next = prev;
            curr = temp;
            temp = prev.next;
            prev.next = curr;
            prev = temp;
        }
    }
}
