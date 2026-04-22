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
        if (head == null || head.next == null || head.next.next == null) {
            return;
        }

        ListNode mid = floyds(head);
        ListNode curr2 = mid.next;
        mid.next = null;
        curr2 = reverseMid(curr2);

        ListNode curr1 = head;

        while (curr1 != null && curr2 != null) {
            ListNode temp = curr1.next;
            curr1.next = curr2;
            curr1 = temp;
            
            temp = curr2.next;
            curr2.next = curr1;
            curr2 = temp;
        }
    }

    private ListNode floyds(ListNode head) {
        ListNode fast = head, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }

    private ListNode reverseMid(ListNode curr) {
        ListNode prev = null;

        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        return prev;
    }
}
