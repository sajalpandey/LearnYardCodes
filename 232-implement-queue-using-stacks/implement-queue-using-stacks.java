class MyQueue {
    Stack<Integer> st;
    public MyQueue() {
        st = new Stack<>();
    }
    
    public void push(int x) {
        st.push(x);
    }
    
    public int pop() {
        if(st.size() == 0)
            return -1;
        Stack<Integer> temp = new Stack<>();
        while(st.size() > 1) {
            temp.push(st.pop());
        }
        int ele = st.pop();
        while(!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return ele;
    }
    
    public int peek() {
        if(st.size() == 0)
            return -1;
        Stack<Integer> temp = new Stack<>();
        while(st.size() > 1) {
            temp.push(st.pop());
        }
        int ele = st.peek();
        temp.push(st.pop());
        while(!temp.isEmpty()) {
            st.push(temp.pop());
        }
        return ele;
    }
    
    public boolean empty() {
        return (st.size() == 0);
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