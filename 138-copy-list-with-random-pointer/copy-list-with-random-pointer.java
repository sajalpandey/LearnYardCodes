/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        /**
        7 --> 13 --> 11 --> 10 --> 1
                     curr             curr           curr            curr
        7 --> (7) --> 13 --> (13) --> 11 --> (11) --> 10 --> (10) --> 1 --> (1) --> null
        */
        // original node = curr
        // mera node = curr.next

        // curr.next.random = curr.random.next
        // original_node.random

        //1. insert copy nodes in between
        if(head == null)
            return null;
        Node curr = head;
        while(curr != null) {
            Node newNode = new Node(curr.val);
            Node temp = curr.next;
            curr.next = newNode;
            newNode.next = temp;

            curr = temp;
        }
        curr = head;
        
        //2. update our nodes random pointers

        while(curr != null) {

            if(curr.random != null) {
                curr.next.random = curr.random.next;
            }

            curr = curr.next.next;
        }

        //separte our list from original one
        Node dummy = new Node(-1);
        dummy.next = head.next;

        curr = head;
        Node ptr = curr.next;
        while(curr != null) {
            curr.next = ptr.next;
            curr = curr.next;
            if(curr == null)
                break;
            ptr.next = curr.next;
            ptr = ptr.next;
        }

        return dummy.next;
    }
}