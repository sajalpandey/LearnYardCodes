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

    public  ListNode reverseList(ListNode head) {
		ListNode t1= null, t2= null, curr = head;
		while(curr != null) {
			t2 = curr.next;
			curr.next = t1;
			t1 = curr;
			curr = t2;
		}
		return t1;
	}
    public void reorderList(ListNode head) {
        // Divide list in two half
		ListNode slow = head, fast = head.next;
		while(fast != null && fast.next != null) {
			slow = slow.next;
			fast = fast.next.next;
		}

		//reverse the other half from mid to last
        ListNode secondList = slow.next;
        
		ListNode newHead = reverseList(secondList);
		slow.next = null;

        slow = head; fast = newHead;
        while(fast != null) {
            ListNode ptr1 = slow.next;
            ListNode ptr2 = fast.next;
            slow.next = fast;
            fast.next = ptr1;

            slow = ptr1;
            fast = ptr2;
        }
    }
}