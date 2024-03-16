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
        Node curr = head;
        while(curr!=null) {
            Node newNode = new Node(curr.val);
            newNode.next = curr.next;
            curr.next = newNode;
            curr = newNode.next;
        }
        curr = head;
        while(curr!=null) {
            System.out.println("curr = "+curr.val);
            if(curr.random!=null)
                curr.next.random = curr.random.next;
            curr = curr.next.next;
        }
        Node dummy = new Node(-1);
        Node ptr = dummy;
        curr = head;
        while(curr!=null) {
            System.out.print("curr = "+curr.val+"  ");
            ptr.next = curr.next;
            ptr = ptr.next;
            curr.next = ptr.next;
            curr = curr.next;
        }
        return dummy.next;
    }
}