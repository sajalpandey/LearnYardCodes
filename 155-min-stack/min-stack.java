class Pair {
    int val;
    int min_val;
    Pair(int v, int m) {
        this.val = v;
        this.min_val = m;
    }
}
class MinStack {
    Stack<Pair> st;
    int mn;
    public MinStack() {
        mn = Integer.MAX_VALUE;
        st = new Stack<>();
    }
    
    public void push(int val) {
        if(st.isEmpty())
            mn = Integer.MAX_VALUE;
        else
            mn = st.peek().min_val;
        mn = Math.min(mn, val);
        st.push(new Pair(val, mn));
    }
    
    public void pop() {
        if(st.size() > 0) {
            Pair p = st.pop();
            //return p.val;
        } 
}
    
    public int top() {
        if(st.size() > 0) {
            Pair p = st.peek();
            return p.val;
        } else  
            return -1;
 
    }
    
    public int getMin() {
        if(st.size() > 0) {
            Pair p = st.peek();
            return p.min_val;
        } else  
            return -1;
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