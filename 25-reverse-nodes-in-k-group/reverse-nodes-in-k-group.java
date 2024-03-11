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
    public void reverseList(ListNode start,ListNode end) {
        ListNode t1 = null,t2=null;
        ListNode curr = start;
        while(t2!=end) {
            if(curr!=null)
                t1 = curr.next;
            curr.next = t2;
            t2 = curr;
            curr = t1;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k==1 || head==null || head.next==null)
            return head;
        ListNode end=head,start=head;
        int size = k-1;
        while(size-->0) {
            end = end.next;
            if(end==null)
                return head;
        }
        ListNode rem_head = reverseKGroup(end.next,k);
        reverseList(start,end);
        start.next = rem_head;
        return end;
    }
}