class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Integer> st = new Stack<>();
        int n = temperatures.length;
        int [] result = new int[n];
        for(int i=n-1; i>=0; i--) {
            while(!st.empty() && temperatures[st.peek()] <= temperatures[i])
                st.pop();
            result[i] = st.empty()==true ? 0 : st.peek() - i;
            st.push(i);
        }
        return result;
    }
}