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
    public ListNode mergeNodes(ListNode head) {
        int sum = 0;
        ListNode ptr = head,curr = head.next;
        while(curr!=null) {
            if(curr.val == 0 && sum!=0) {
                ptr.next.val = sum;
                ptr = ptr.next;
                sum = 0;
            }
            sum += curr.val;
            curr = curr.next;
        }
        ptr.next = null;
        return head.next;
    }
}