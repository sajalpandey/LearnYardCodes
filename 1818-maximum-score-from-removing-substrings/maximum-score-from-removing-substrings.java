class Solution {
    Stack<Character> st = new Stack<>();
    public int findOpBA(String str, int x, int y) {
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'b')
                st.push('b');
            else if(str.charAt(i) == 'a') {
                if(!st.isEmpty() && st.peek() == 'b') {
                    result += y;
                    st.pop();
                } else
                    st.push('a');
            } else {
                StringBuilder ptr = new StringBuilder();
                while(!st.isEmpty()) {
                    ptr.append(st.peek());
                    st.pop();
                }
                ptr.reverse();
                result += findOpAB(ptr.toString(), x, y);
                st.clear();
            }
                
        }
        return result;
    }
    public int findOpAB(String str, int x, int y) {
        int result = 0;
        for(int i=0; i<str.length(); i++) {
            if(str.charAt(i) == 'a')
                st.push('a');
            else if(str.charAt(i) == 'b') {
                if(!st.isEmpty() && st.peek() == 'a') {
                    result += x;
                    st.pop();
                } else
                    st.push('b');
            } else {
                StringBuilder ptr = new StringBuilder();
                while(!st.isEmpty()) {
                    ptr.append(st.peek());
                    st.pop();
                }
                ptr.reverse();
                result += findOpBA(ptr.toString(), x, y);
                st.clear();
            }
                
        }
        return result;
    }
    public int maximumGain(String s, int x, int y) {
        int result = 0;
        if(y > x) {
            result += findOpBA(s, x,y );
            StringBuilder str = new StringBuilder();
            while(!st.isEmpty()) {
                str.append(st.peek());
                st.pop();
            }
            str.reverse();
            result += findOpAB(str.toString(), x,y);
        } else {
            result += findOpAB(s, x, y);
            StringBuilder str = new StringBuilder();
            while(!st.isEmpty()) {
                str.append(st.peek());
                st.pop();
            }
            str.reverse();
            result += findOpBA(str.toString(), x, y);
        }
        
        return result;
    }
}