class Solution {
    public String removeOuterParentheses(String str) {
        int n = str.length();
        StringBuilder temp = new StringBuilder();
        Stack<Character> st = new Stack<>();
        int i = 0;
        while(i < n) {
            if(str.charAt(i) == '(' && st.isEmpty())
                st.push(str.charAt(i));
            else if(str.charAt(i) == '(') {
                st.push(str.charAt(i));
                temp.append(str.charAt(i));
            } else if(str.charAt(i) == ')' && st.size() > 1) {
                st.pop();
                temp.append(str.charAt(i));
            } else
                st.pop();
            i++;
        }
        return temp.toString();
    }
}