class Solution {
    public int longestPalindromeSubseqHelper(String s, int i, int j) {
        if(i == j)
            return 1;
        if(j < i)
            return 0;
        
        int op1 = 0, op2 = 0;
        if(s.charAt(i) == s.charAt(j))
            op1 = (2 + longestPalindromeSubseqHelper(s, i+1, j-1));
        
        op2 = Math.max(longestPalindromeSubseqHelper(s, i+1, j), longestPalindromeSubseqHelper(s, i, j-1));

        return Math.max(op1, op2);
        
    }

    public int longestPalindromeSubseqTopDown(String s, int i, int j, int[][] dp) {
        if(i == j)
            return 1;
        if(j < i)
            return 0;
        
        if(dp[i][j] != -1)
            return dp[i][j];

        int op1 = 0, op2 = 0;
        if(s.charAt(i) == s.charAt(j))
            op1 = (2 + longestPalindromeSubseqTopDown(s, i+1, j-1, dp));
        
        op2 = Math.max(longestPalindromeSubseqTopDown(s, i+1, j, dp), longestPalindromeSubseqTopDown(s, i, j-1, dp));

        return dp[i][j] = Math.max(op1, op2);
        
    }

    public int longestPalindromeSubseq(String s) {
        int n = s.length();
        //1. Recursion
        //return longestPalindromeSubseqHelper(s, 0, s.length()-1);


        //2. DP Top Down
        // int[][] dp = new int[n][n];
        // for(int [] row : dp)
        //     Arrays.fill(row, -1);
        
        // return longestPalindromeSubseqTopDown(s, 0, n-1, dp);

        int[][] dp = new int[n][n];

    // Base case: single character is a palindrome of length 1
    for (int i = 0; i < n; i++) {
        dp[i][i] = 1;
    }

    // Bottom-up iteration to solve subproblems
    for (int len = 2; len <= n; len++) {
        for (int i = 0; i <= n - len; i++) {
            int j = i + len - 1;
            if (s.charAt(i) == s.charAt(j)) {
                dp[i][j] = 2 + (len > 2 ? dp[i + 1][j - 1] : 0); // Increase palindrome length by 2
            } else {
                dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]); // Choose the maximum of the two substrings
            }
        }
    }

    return dp[0][n - 1];
    }
}