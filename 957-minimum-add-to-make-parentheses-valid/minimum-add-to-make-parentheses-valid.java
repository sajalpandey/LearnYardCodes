class Solution {
    public int minAddToMakeValid(String s) {
        int result = 0;
        /**
        if '(' found then simply increase opening braces count
        else if ')' if opening > 0 then decrease it
                    other wise increase out result
        */
        int op = 0, cl = 0;
        for(char ch : s.toCharArray()) {
            if(ch == '(')
                op++;
            else {
                if(op > 0)
                    op--;
                else
                    result++;
            }
        }
        result += op;
        return result;
    }
}