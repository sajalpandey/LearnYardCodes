class MyQueue {
    ArrayList<Integer> arr;
    int front;
    public MyQueue() {
        arr = new ArrayList<>();
        front = 0;
    }
    
    public void push(int x) {
        arr.add(x);
    }
    
    public int pop() {
        return arr.get(front++);
    }
    
    public int peek() {
        return arr.get(front);
    }
    
    public boolean empty() {
        return front==arr.size();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */