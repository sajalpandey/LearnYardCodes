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
    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode ptr = dummy;
        ListNode oddH = head, odd = head;
        ListNode evenH = head.next ,even = head.next;
        ptr = head;
        while(even != null && odd != null) {
            odd.next = even.next;
            odd = odd.next;
            if(odd != null)
                even.next = odd.next;
            if(even != null)
                even = even.next;
        }
        even = evenH;
        odd = oddH;
        // while(odd != null) {
        //     System.out.print(odd.val+" ");
        //     odd = odd.next;
        // }
        // System.out.println();
        // while(even != null) {
        //     System.out.print(even.val+" ");
        //     even = even.next;
        // }
        even = evenH;
        odd = oddH;
        while(even != null) {
            ListNode p1 = odd.next;
            ListNode p2 = even.next;
            even.next = odd;
            if(p2 != null)
                odd.next = p2;
            odd = p1; 
            even = p2;
        }
        return evenH;
    }
}