class Solution {
    public boolean backspaceCompare(String s, String t) {
        Stack<Character> st = new Stack<>();
        Stack<Character> tt = new Stack<>();
        for(char c : s.toCharArray()) {
            if(c == '#' && !st.empty())
                st.pop();
            else if(c != '#')
                st.push(c);
        }

        for(char c : t.toCharArray()) {
            if(c == '#' && !tt.empty())
                tt.pop();
            else if(c != '#')
                tt.push(c);
        }
        if(st.size()!=tt.size())
            return false;
        else {
            while(!st.empty() && !tt.empty()) {
                if(st.peek()!=tt.peek())
                    return false;
                st.pop();
                tt.pop();
            }
        }
        return true;
    }
}