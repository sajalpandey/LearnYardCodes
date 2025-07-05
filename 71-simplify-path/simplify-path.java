class Solution {
    public String simplifyPath(String path) {
        Stack<String> st = new Stack<>();
        String[] parts = path.split("/");
        for (String str : parts) {
            if (str.equals(".") || str.isEmpty())
                continue;
            else if (str.equals("..")) {
                if (!st.isEmpty()) {
                    st.pop();
                }
            } else {
                st.push(str);
            }
        }
        StringBuilder result = new StringBuilder();
        while(!st.isEmpty()) {
            result.insert(0, "/" + st.pop());
        }
        if(result.length() == 0)
            return "/";
        else
            return result.toString();
    }
}