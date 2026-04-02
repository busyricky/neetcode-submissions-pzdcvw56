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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode curr1 = l1, curr2 = l2, response = new ListNode();
        int sum = 0, counter = 0;
        while (curr1 != null && curr2 != null) {
            sum += (curr1.val + curr2.val) * Math.pow(10,counter);
            curr1 = curr1.next;
            curr2 = curr2.next;
            counter++;
        }

        if (curr1 != null) {
            response = l1;
            while (curr1 != null) {
                sum += curr1.val * Math.pow(10,counter);
                counter++;
                curr1 = curr1.next;
            }
        } else {
            response = l2;
            while (curr2 != null) {
                sum += curr2.val * Math.pow(10,counter);
                counter++;   
                curr2 = curr2.next;        
            }
        }

        ListNode curr = response;
        while (sum > 0) {
            curr.val = sum % 10;
            sum = sum / 10;
            if (sum <= 0 ) { break; }
            else if (curr.next == null) { curr.next = new ListNode(); }
            curr = curr.next;
        }

        return response;
    }
}
