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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        ListNode dummy = new ListNode(-1);
        dummy.next = head;
        ListNode prev=dummy,ptr=head;
        --left; // 0
        --right; // 3
        while(ptr!=null) {
            if(left==0) {
                ListNode curr = ptr,t1=null,t2=null;
                int nodes = right+1;
                while(curr!=null && nodes-- > 0) {
                    t1 = curr.next;
                    curr.next = t2;
                    t2 = curr;
                    curr = t1;
                }
                prev.next = t2;
                ptr.next = t1;
                break;
            }
            left--; //-1
            right--; //2
            prev = ptr;
            ptr = ptr.next;
        }
        return dummy.next;
    }
}