class MyHashMap {

    int size = 400;
    LinkedList<Node> [] map;
    class Node {
        int key;
        int value;
        Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    } 
    public MyHashMap() {
        map = new LinkedList[size];
    }
    
    public void put(int key, int value) {
        int bucket = key % size;
        if(map[bucket] == null)
            map[bucket] = new LinkedList<Node>();
        LinkedList<Node> list = map[bucket];
        for(Node node : list) {
            if(node.key == key) {
                node.value = value;
                return;
            }
        }
        map[bucket].add(new Node(key,value));
        return;
    }
    
    public int get(int key) {
        int bucket = key % size;
        if(map[bucket] == null)
            return -1;
        else {
            LinkedList<Node> list = map[bucket];
            for(Node node : list) {
                if(node.key == key)
                    return node.value;
            }
        }
        return -1;
    }
    
    public void remove(int key) {
        int bucket = key % size;
        if(map[bucket] == null)
            return;
        LinkedList<Node> list = map[bucket];
        Node toRemove = null;
        for(Node node : list) {
            if(node.key == key)
                toRemove = node;
        }
        if(toRemove == null) return;
        map[bucket].remove(toRemove);
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */