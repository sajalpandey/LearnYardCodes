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
    public ListNode modifiedList(int[] nums, ListNode head) {
        HashSet<Integer> set = new HashSet<>();
        for(int ele : nums)
            set.add(ele);
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        dummy.next = head;
        while(head != null) {
            if(!set.contains(head.val)) {
                curr.next = new ListNode(head.val);
                curr = curr.next;
            }
            head = head.next;
        }

        return dummy.next;
    }
}