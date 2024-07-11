class Solution {
    public void reverseSubstring(StringBuilder sb, int a, int b) {
        // Check for valid indices
        if (a < 0 || b >= sb.length() || a >= b) 
            return ;
        while (a < b) {
            char temp = sb.charAt(a);
            sb.setCharAt(a, sb.charAt(b));
            sb.setCharAt(b, temp);
            a++;
            b--;
        }
    }
    public String reverseParentheses(String s) {
        Stack<Integer> st = new Stack<>();
        StringBuilder temp = new StringBuilder();
        for(int i=0; i<s.length(); i++) {
            if(s.charAt(i) == '(')
                st.push(temp.length());
            else if(s.charAt(i) == ')') {
                reverseSubstring(temp, st.peek(), temp.length()-1);
                st.pop();
            } else
                temp.append(s.charAt(i));
        }
        return temp.toString();
    }
}