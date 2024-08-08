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
    public ListNode merge(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(left!= null && right!= null) {
            if(left.val <= right.val) {
                ptr.next = left;
                left = left.next;
            } else {
                ptr.next = right;
                right = right.next;
            }
            ptr = ptr.next;
        }
        if(left != null)
            ptr.next = left;
        else
            ptr.next = right;
        return dummy.next;
    }
    public ListNode sortList(ListNode head) {
        if(head == null || head.next == null)
            return head;

        ListNode slow = head, fast = head.next;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode right = slow.next;
        slow.next = null;
        ListNode left = sortList(head);
        right = sortList(right);
        
        return merge(left, right);
    }
}