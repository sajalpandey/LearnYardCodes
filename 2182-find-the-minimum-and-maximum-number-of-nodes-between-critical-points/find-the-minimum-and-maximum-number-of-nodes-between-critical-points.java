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
    public int[] nodesBetweenCriticalPoints(ListNode head) {
        ListNode prev = head, curr = head.next, next = curr.next;
        int index = 1;
        ArrayList<Integer> l = new ArrayList<>();
        while(next != null) {
            if(prev.val < curr.val && curr.val > next.val) {
                //local maxima
                l.add(index);
            } else if(prev.val > curr.val && curr.val < next.val) {
                //local minima
                l.add(index);
            }
            prev = curr;
            curr = next;
            next = next.next;
            index++;
        }
        Collections.sort(l);
        if(l.size() < 2)
            return new int[] {-1,-1};
        int mn = Integer.MAX_VALUE;
        for(int i=0; i<l.size()-1; i++) {
            mn = Math.min(mn, l.get(i+1)-l.get(i));
        }
        int mx = l.get(l.size()-1)-l.get(0);
        return new int[]{mn, mx};

    }
}