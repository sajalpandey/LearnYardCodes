class Solution {
    public boolean isOperator(String str) {
        return (str.equals("+") || str.equals("-") || str.equals("*") || str.equals("/"));
    }

    public int evalRPN(String[] tokens) {
        int result = 0;
        if(tokens.length==1)
            return Integer.parseInt(tokens[0]);
        Stack<Integer> st = new Stack<>();
        for(int i=0; i<tokens.length; i++) {
            if(isOperator(tokens[i])) {
                int ele1 = st.peek();
                st.pop();
                int ele2 =  st.peek();
                st.pop();
                //System.out.println("ele1 = "+ele1);
                //System.out.println("ele2 = "+ele2);
                if(tokens[i].equals("*"))
                    result = ele1*ele2;
                else if(tokens[i].equals("/"))
                    result = ele2/ele1;
                else if(tokens[i].equals("+"))
                    result = ele1+ele2;
                else
                    result = ele2-ele1;
                //System.out.println(result);
                st.push(result);
            } else
                st.push(Integer.parseInt(tokens[i]));
        }
        return result;
    }
}