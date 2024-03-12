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
    public ListNode reverseList(ListNode head) {
        ListNode t1=null,t2=null,curr=head;
        while(curr!=null) {
            t2 = curr.next;
            curr.next = t1;
            t1 = curr;
            curr = t2;
        }
        return t1;
    }
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast!=null && fast.next!=null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        // we have even no of nodes in LL
        ListNode head2;
        if(fast==null)
            head2 = reverseList(slow);
        else // Odd no of nodes in LL
            head2 = reverseList(slow.next);
        ListNode curr = head;
        while(head2!=null) {
            if(head2.val!=curr.val)
                return false;
            head2 = head2.next;
            curr = curr.next;
        }
        return true;
    }
}