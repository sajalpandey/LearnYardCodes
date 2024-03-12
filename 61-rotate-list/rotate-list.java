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
    public ListNode rotateRight(ListNode head, int k) {
        int size = 0;
        if(head==null)
            return head;
        ListNode curr = head,fast=null;
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        curr = head;
        k = k % size;
        if(k==0)
            return head;
        for(int i=0; i<(size-k-1) && curr!=null; i++)
            curr = curr.next;
        if(curr!=null)
            fast = curr.next;
        ListNode newHead = fast;
        while(fast.next!=null)
            fast = fast.next;
        curr.next = null;
        fast.next =  head;
        return newHead;
    }
}