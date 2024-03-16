class MinStack {

    Stack<Integer> ele, mn_st;
    public MinStack() {
        ele = new Stack<>();
        mn_st =  new Stack<>();
    }
    
    public void push(int val) {
        ele.push(val);
        if(!mn_st.empty())
            mn_st.push(Math.min(mn_st.peek(),val));
        else
            mn_st.push(val);
    }
    
    public void pop() {
        ele.pop();
        mn_st.pop();
    }
    
    public int top() {
        return ele.peek();
    }
    
    public int getMin() {
        return mn_st.peek();
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