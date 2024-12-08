class Solution {
    public int helper(String word1, String word2, int i, int j) {
        if(i < 0)
            return j+1;
        if(j < 0)
            return i+1;
        //if char matches
        if(word1.charAt(i) == word2.charAt(j))
            return (0 + helper(word1, word2, i-1, j-1));
        else
            return (1 + Math.min(helper(word1, word2, i, j-1), 
            Math.min(helper(word1, word2, i-1, j), 
            helper(word1, word2, i-1, j-1))));
    }

    public int topDownhelper(String word1, String word2, int i, int j, int[][] dp) {
        if(i == 0)
            return j;
        if(j == 0)
            return i;
        if(dp[i][j] != -1)
            return dp[i][j];

        //if char matches
        if(word1.charAt(i-1) == word2.charAt(j-1))
            return dp[i][j]= (0 + topDownhelper(word1, word2, i-1, j-1, dp));
        else
            return dp[i][j] = (1 + Math.min(topDownhelper(word1, word2, i, j-1, dp), 
            Math.min(topDownhelper(word1, word2, i-1, j, dp), 
            topDownhelper(word1, word2, i-1, j-1, dp))));
    }

    public int minDistance(String word1, String word2) {
        //recursion
        int n = word1.length(), m = word2.length();
        // return helper(word1, word2, n-1, m-1);

        //to avoid i<0 && j<0 case in bottom up we will update index in topdown
        int[][] dp = new int[n+1][m+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        
        // return topDownhelper(word1, word2, n, m, dp);

        //Bottom Up
        //base case
        for(int i=0; i<=n; i++)
            dp[i][0] = i;
        for(int j=0; j<=m; j++)
            dp[0][j] = j;
        
        for(int i=1; i<=n; i++) {
            for(int j=1; j<=m; j++) {
                if(word1.charAt(i-1) == word2.charAt(j-1))
                    dp[i][j]= (0 + dp[i-1][j-1]);
                else
                    dp[i][j] = (1 + Math.min(dp[i][j-1] , Math.min(dp[i-1][j] ,dp[i-1][j-1])));
            }
        }
        return dp[n][m];
    }
}