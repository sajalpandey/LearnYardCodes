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
    public ListNode mergeKLists(ListNode[] lists) {

        if(lists.length == 0)
            return null;
        //create a min heap
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((a,b) -> (a.val-b.val));

        //add nodes in list(klogk)
        for(int i=0; i<lists.length; i++) {
            if(lists[i] != null)
                minHeap.add(lists[i]);
        }
        ListNode dummy = new ListNode(-1);
        ListNode ptr = dummy;
        while(!minHeap.isEmpty()) {
            ListNode temp = minHeap.poll();
            ptr.next = temp;

            if(temp.next != null) {
                minHeap.add(temp.next);
            }
            ptr = ptr.next;
        }
        return dummy.next;
    }
}