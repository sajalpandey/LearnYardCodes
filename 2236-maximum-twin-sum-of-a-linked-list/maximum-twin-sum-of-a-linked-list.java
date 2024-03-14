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
    public ListNode reverse(ListNode head) {
        ListNode curr = head, t1=null,t2=null;
        while(curr!=null) {
            t2 = curr.next;
            curr.next = t1;
            t1 = curr;
            curr = t2;
        }
        return t1;
    }
    public int pairSum(ListNode head) {
        ListNode slow = head, fast = head,ptr=head;
        while(fast!=null && fast.next!=null) {
            ptr = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        ptr.next = null;
        ListNode reversedPtr = reverse(slow);
        int max_sum = Integer.MIN_VALUE;
        fast = head;
        while(fast!=reversedPtr) {
            max_sum = Math.max(max_sum, fast.val + reversedPtr.val);
            fast = fast.next;
            reversedPtr = reversedPtr.next;
        }
        return max_sum;
    }
}