class Node {
    int data;
    Node next;
    Node() {
        this.next=null;
        this.data=0;
    }
    Node(int val) {
        this.data = val;
        this.next = null;
    }
}
class MyLinkedList {
    int length;
    Node head;
    public MyLinkedList() {
        this.length = 0;
        this.head = null;
    }
    
    public int get(int index) {
        int i=0;
        Node temp = head;
        if(index <0 || index >= this.length)
            return -1;
        while(i < index) {
            System.out.println("i = "+i+" temp.data = ");
            i++;
            temp = temp.next;
        }
        return temp.data;
    }
    
    public void addAtHead(int val) {
        Node newNode = new Node(val);
        newNode.next = this.head;
        this.head = newNode;
        this.length++;
    }
    
    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if(this.length==0) {
            addAtHead(val);
            return;
        }
        Node temp = this.head;
        while(temp.next!=null)
            temp = temp.next;
        temp.next = newNode;
        this.length++;
    }
    
    public void addAtIndex(int index, int val) {
        if(index > this.length)
            return;
        if(index==0) {
            addAtHead(val);
            return;
        }
        else if(index==this.length) {
            addAtTail(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        for(int i=0; i<index-1; i++) {
            temp = temp.next;
        }
        System.out.println(temp.data);
        newNode.next = temp.next;
        temp.next = newNode;
        this.length++;
    }
    
    public void deleteAtIndex(int index) {
        if(index >= this.length)
            return;
        Node temp = head,prev=temp;
        if(index==0) {
            head = head.next;
            this.length--;
            return;
        }
        for(int i=0; i<index; i++){
            prev = temp;
            temp = temp.next;
        }
        prev.next = temp.next;
        this.length--;
    }
}

/**
 * Your MyLinkedList object will be instantiated and called as such:
 * MyLinkedList obj = new MyLinkedList();
 * int param_1 = obj.get(index);
 * obj.addAtHead(val);
 * obj.addAtTail(val);
 * obj.addAtIndex(index,val);
 * obj.deleteAtIndex(index);
 */