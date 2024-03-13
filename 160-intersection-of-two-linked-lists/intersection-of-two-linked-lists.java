/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int getLength(ListNode head) {
        int len = 0;
        ListNode curr = head;
        while(curr!=null) {
            curr=curr.next;
            len++;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = getLength(headA);
        int len2 = getLength(headB);

        ListNode currA = headA,currB=headB;
        System.out.println(len1+" -- "+len2);
        
        while((len1-len2) > 0) {
            currA = currA.next;
            len1--;
        }
        while((len2-len1) > 0) {
            currB =currB.next;
            len2--;
        }
        
        while(currA!=currB) {
            currA=currA.next;
            currB=currB.next;
        }
        return currA;
    }   
}