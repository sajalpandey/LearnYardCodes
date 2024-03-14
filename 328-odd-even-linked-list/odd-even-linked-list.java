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
    public ListNode oddEvenList(ListNode head) {
        if(head==null || head.next==null || head.next.next==null)
            return head;
        ListNode oddHead = head, odd = head;
        ListNode evenHead = head.next, even =  head.next,prev=odd;
        while(odd!=null && even!=null) {
            odd.next = even.next;
            prev = odd;
            odd = odd.next;
            if(odd!=null)
                even.next = odd.next;
            even = even.next;
        } 
        if(odd!=null)
            odd.next = evenHead;
        else
            prev.next = evenHead;
        return oddHead;
    }
}