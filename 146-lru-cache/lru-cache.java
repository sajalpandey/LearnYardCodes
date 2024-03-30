class LRUCache {

    class Node {
        int key;
        Node next;
        Node prev;
        Node(int d) {
            key = d;
            next = null;
            prev = null;
        }
    }
    class CustomLinkedList {
        Node head;
        Node tail;
        int size;
        CustomLinkedList() {
            head = tail = null;
            size = 0;
        }
        Node pushBack(int num) {
            Node newNode = new Node(num);
            if(size==0) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
            size++;
            return newNode;
        }
        void delNode(Node curr) {
            if(size==1) {
                tail = head = null;
            } else if(head==curr) {
                head = head.next;
                head.prev = null;
            } else if(tail==curr) {
                tail = curr.prev;
                tail.next = null;
            } else {
                Node nextNode = curr.next;
                Node prevNode = curr.prev;
                prevNode.next = nextNode;
                nextNode.prev = prevNode;
            }
            size--;
        }

    }
    HashMap<Integer, Integer> keyToValue;
    HashMap<Integer, Node> keyToNode;
    CustomLinkedList orderOfKeys;
    int cap;
    public LRUCache(int capacity) {
        keyToValue = new HashMap<>();
        keyToNode = new HashMap<>();
        orderOfKeys = new CustomLinkedList();
        cap = capacity;
    }
    public void updateTimeToNow(int key) {
        if(keyToNode.containsKey(key)) {
            Node currNode = keyToNode.get(key);
            orderOfKeys.delNode(currNode);
        }
        Node newRef = orderOfKeys.pushBack(key);
        keyToNode.put(key, newRef);
    }
    public int get(int key) {
        // if this key is present , then we need to update time
        if(keyToValue.containsKey(key)) {
            updateTimeToNow(key);
        }
        return keyToValue.getOrDefault(key,-1);
    }
    public void deleteLruNode(){
        int key = orderOfKeys.head.key;
        keyToValue.remove(key);
        keyToNode.remove(key);

        orderOfKeys.delNode(orderOfKeys.head);
    }
    public void put(int key, int value) {
        keyToValue.put(key, value);
        updateTimeToNow(key);

        if(keyToValue.size() > cap) {
            deleteLruNode();
        }
    }
}

/**
 * Your LRUCache object will be instantiated and called as such:
 * LRUCache obj = new LRUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */