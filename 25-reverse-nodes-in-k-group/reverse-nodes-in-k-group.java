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
    public ListNode reverseKGroup(ListNode head, int k) {
        if(k == 1 || head == null)
            return head;
        int count = 0;
        ListNode current = head;
        while(count < k && current != null) {
            current = current.next;
            count++;
        }

        if(count == k) {
            //means we can reverse these K nodes
            ListNode t1 = null, t2 = null, curr = head;
            for(int i=0; i<k; i++) {
                t2 = curr.next;
                curr.next = t1;
                t1 = curr;
                curr = t2;
            }

            head.next = reverseKGroup(curr, k);

            return t1;
        } else
            return head;
    }
}