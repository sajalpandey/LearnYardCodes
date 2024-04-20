class Solution {
    public static void helper(List<String> result, StringBuilder str, int open, int close, int n) {
        if(close > open || open > n || close > n)
            return;

        if(open + close == 2* n) {
            result.add(str.toString());
            return;
        }

        if(open < n) {
            str.append('(');
            helper(result, str, open+1, close, n);
            str.deleteCharAt(str.length()-1);
        } 
        
        if(close <= open) {
            str.append(')');
            helper(result, str, open, close+1, n);
            str.deleteCharAt(str.length()-1);
        }

    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        StringBuilder str = new StringBuilder();
        helper(result, str,0,0,n);
        return result;
        /**
        n = 1
        ()
        open_b < Close
        always open >= close --> open == close
        n = 2
        ()() , (())
        Close > open -- return
        if open + close == 2 * n
        ans array me append
        n = 3
        )   )()(), (( ))(), ( ) ( ( ) ), (()()), ((()))
         */
    }
}