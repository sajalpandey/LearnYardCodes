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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode curr = head;
        while(curr != null) {
            size++;
            curr = curr.next;
        }
        int nodeToDelete = size - n;
        ListNode prev = head ; curr = head;
        if(nodeToDelete == 0)
            return head.next;
        while(curr != null && nodeToDelete-- > 0) {
            prev = curr;
            curr = curr.next;
        }
        prev.next = curr.next;
        curr.next = null;
        return head;
    }
}