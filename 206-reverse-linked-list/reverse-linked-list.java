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
        ListNode t1 = null,t2=null;
        ListNode curr = head;
        while(curr!=null) {
            t1 = curr.next;
            curr.next = t2;
            t2 = curr;
            curr = t1;
        }
        return t2;
    }
}