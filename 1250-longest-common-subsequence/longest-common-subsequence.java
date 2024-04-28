class Solution {
    public int longestCommonSubsequenceHelper(int i, int j, String text1, String text2) {
        if(i >= text1.length() || j >= text2.length())
            return 0;
        
        if(text1.charAt(i) == text2.charAt(j)) {
            return (1 + longestCommonSubsequenceHelper(i+1, j+1, text1, text2));
        } else {
            return Math.max(longestCommonSubsequenceHelper(i+1, j, text1, text2), longestCommonSubsequenceHelper(i, j+1, text1, text2));
        }
    }

    public int longestCommonSubsequenceTopDown(int i, int j, String text1, String text2, int[][]dp) {
        if(i >= text1.length() || j >= text2.length())
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];
        if(text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = (1 + longestCommonSubsequenceTopDown(i+1, j+1, text1, text2, dp));
        } else {
            dp[i][j] = Math.max(longestCommonSubsequenceTopDown(i+1, j, text1, text2, dp), longestCommonSubsequenceTopDown(i, j+1, text1, text2, dp));
        }
        return dp[i][j];
    }
    public int longestCommonSubsequence(String text1, String text2) {

        //1. Recursive
        //return longestCommonSubsequenceHelper(0, 0, text1, text2);

        //2. DP : Top Down
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return longestCommonSubsequenceTopDown(0, 0, text1, text2, dp);

        //3. DP : Bottom Up
        //Base condition if one of the string is empty
        for(int i=0; i<=text1.length(); i++)
            dp[i][0] = 0;

        for(int j=0; j<=text2.length(); j++)
            dp[0][j] = 0;

        for(int i=1; i<=text1.length(); i++) {
            for(int j=1; j<=text2.length(); j++) {

                //when char at i & j are equal
                if(text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = (1 + dp[i-1][j-1]);
                } 
                // else max
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[text1.length()][text2.length()];
    }
}