class Solution {
    public int helper(String text1, String text2, int i, int j) {
        if(i >= text1.length() || j >= text2.length())
            return 0;
        
        //we have 3 options
        //if both char matches then call recursion with next index
        //if does'nt match then increse either of i then j
        int op1 = 0, op2 = 0, op3 = 0;
        if(text1.charAt(i) == text2.charAt(j))
            op1 = (1 + helper(text1, text2, i+1, j+1));
        else {
            op2 = helper(text1, text2, i+1, j);
            op3 = helper(text1, text2, i, j+1);
        }
        return Math.max(op1, Math.max(op2, op3));
    }

    public int helperTopDown(String text1, String text2, int i, int j, int[][] dp) {
        if(i == 0 || j == 0)
            return 0;
            
        if(dp[i][j] != -1)
            return dp[i][j];

        int op1 = 0, op2 = 0, op3 = 0;
        if(text1.charAt(i-1) == text2.charAt(j-1)) {
            op1 = 1 + helperTopDown(text1, text2, i-1, j-1, dp);
        } else {
            op2 = helperTopDown(text1, text2, i-1, j, dp);
            op3 = helperTopDown(text1, text2, i, j-1, dp);
        }

        return dp[i][j] = Math.max(op1, Math.max(op2, op3));
    }
    public int longestCommonSubsequence(String text1, String text2) {
        // return helper(text1, text2, 0, 0);

        int m = text1.length(), n = text2.length();
        int[][] dp = new int[m+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return helperTopDown(text1, text2, m, n, dp);
    }
}