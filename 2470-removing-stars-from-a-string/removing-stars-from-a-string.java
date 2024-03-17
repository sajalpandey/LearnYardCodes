class Solution {
    public String removeStars(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0; i<s.length(); ++i) {
            if(st.empty())
                st.push(s.charAt(i));
            else{
                if(s.charAt(i) == '*') {
                    st.pop();
                } else 
                    st.push(s.charAt(i));
            }
        }
        //StringBuilder result = new StringBuilder();
        String result = "";
        while(!st.empty()) {
            result = st.peek() + result;
            //result.insert(0,st.peek());
            st.pop();
        }
        return result;
    }
}