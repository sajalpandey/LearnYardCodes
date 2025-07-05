class Solution {
    public void helper(int open, int close, int n, StringBuilder str, List<String> result) {
        if(close > open)
            return;
        if(str.length() == 2 * n) {
            result.add(str.toString());
            return;
        }
        if(open < n) {
            str.append('(');
            helper(open+1, close, n, str, result);
            str.deleteCharAt(str.length()-1);
        }
        if(close <= open) {
            str.append(')');
            helper(open, close+1, n, str, result);
            str.deleteCharAt(str.length()-1);
        }
        return;
    }
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<>();
        helper(0, 0, n, new StringBuilder(), result);
        return result;
    }
}