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
        while(curr!=null) {
            size++;
            curr = curr.next;
        }
        int removeNode = size - n; // 3
        if(removeNode==0)
            return head.next;
        curr = head;
        ListNode prev = head;
        while(curr!=null) {
            if(removeNode==0) {
                prev.next = curr.next;
                break;
            }
            removeNode--;
            prev = curr;
            curr = curr.next;
        }
        return head;
    }
}