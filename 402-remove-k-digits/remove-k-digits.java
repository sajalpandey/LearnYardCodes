class Solution {
    public String removeKdigits(String num, int k) {
        if (num.length() == k) {
            return "0";
        }
        Stack<Character> st = new Stack<>();
        for(int i=0; i<num.length(); i++) {
            while(!st.empty() && k > 0 &&  st.peek() > num.charAt(i)) {
                st.pop();
                k--;
            }
            st.push(num.charAt(i));
        }
        while(k > 0 && !st.empty()) {
            k--;
            st.pop();
        }
        StringBuilder result = new StringBuilder();
        while(!st.empty()) {
            result.append(st.peek());
            st.pop();
        }
        result.reverse();
        while(result.charAt(0)=='0' && result.length() > 1)
            result.deleteCharAt(0);
        return result.toString();
    }
}