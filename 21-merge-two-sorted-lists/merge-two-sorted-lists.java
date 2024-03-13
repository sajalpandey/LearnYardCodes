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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode newHead = null;
        ListNode dummy = new ListNode(-101);
        ListNode curr = dummy;
        if(l1==null)
            return l2;
        if(l2==null)    
            return l1;
        while(l1!=null && l2!=null) {
            System.out.println("l1.val = "+l1.val+" -- l2.val = "+l2.val);
            if(l1.val <= l2.val) {
                curr.next = l1;
                l1 = l1.next;
            } else {
                curr.next = l2;
                l2 = l2.next;
            }
            curr = curr.next;
        }
        if(l1==null)
            curr.next = l2;
        if(l2==null)
            curr.next = l1;
        return dummy.next;
    }
}