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
        int carry = 0;
        ListNode dummy = new ListNode(-1);
        ListNode tail = dummy;
        while(l1!=null || l2!=null || carry!=0) {
            int d1 = (l1!=null ? l1.val : 0);
            int d2 = (l2!=null ? l2.val : 0);

            int sum = d1 + d2 + carry;
            carry = sum / 10;
            int val = sum % 10;

            ListNode newNode = new ListNode(val);
            tail.next = newNode;
            tail = tail.next;

            l1 = (l1!=null ? l1.next : null);
            l2 = (l2!=null ? l2.next : null);

        }

        return dummy.next;
        // ListNode result = dummy.next;
        // dummy.next = null;
        // return result;
    }
}