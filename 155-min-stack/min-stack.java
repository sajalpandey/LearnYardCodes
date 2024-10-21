class Pair {
    int ele;
    int min_ele;
    Pair(int a, int b) {
        this.ele = a;
        this.min_ele = b;
    }
}
class MinStack {
    Stack<Pair>  st;

    public MinStack() {
        st = new Stack<>();
    }
    
    public void push(int ele) {
        if(st.isEmpty()) {
            st.push(new Pair(ele, ele));
        } else {
            st.push(new Pair(ele, Math.min(ele, st.peek().min_ele)));
        }
    }
    
    public void pop() {
        if(!st.isEmpty())
            st.pop();
    }
    
    public int top() {
        return st.peek().ele;
    }
    
    public int getMin() {
        return st.peek().min_ele;
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */