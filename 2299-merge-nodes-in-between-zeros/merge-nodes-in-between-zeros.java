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
        ListNode newHead = null, curr = head, temp = newHead;
        int sum = 0;
        while(curr != null) {
            ListNode ptr = curr.next;
            sum = 0;
            while(ptr != null && ptr.val != 0) {
                sum += ptr.val;
                ptr = ptr.next;
            }
            if(sum == 0)
                break;
            ListNode newNode = new ListNode(sum);
            if(newHead == null) {
                newHead = newNode;
                temp = newHead;
            } else {
                temp.next = newNode;
                temp = temp.next;
            }
            curr = ptr;
        }
        return newHead;
    }
}