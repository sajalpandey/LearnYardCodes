class Pair {
    int index;
    int value;
    Pair(int i, int v) {
        this.index = i;
        this.value = v;
    }
}
class StockSpanner {

    Stack<Pair> st;
    int index = -1;
    public StockSpanner() {
        st = new Stack<>();
    }
    
    public int next(int price) {
        index++;
        if(st.isEmpty() || !st.isEmpty() && st.peek().value > price) {
            st.push(new Pair(index, price));
            return 1;
        } else {
            while(!st.isEmpty() && st.peek().value <= price) {
                st.pop();
            }
            int ans = (index - (st.isEmpty() ? -1 : st.peek().index));
            st.push(new Pair(index, price));
            return ans;
        }
        
    }
}

/**

[100,80,60,70,60,75,85]
[-1,-1,-1,2,]

 */
/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */