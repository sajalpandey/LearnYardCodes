class Solution {
    public int minDistanceHelper(String word1, String word2, int i, int j, int[][] dp) {
        if(i == word1.length())
            return word2.length() - j;
        
        if(j == word2.length())
            return word1.length() - i;
            
        if(dp[i][j] != -1)
            return dp[i][j];
        //char of both word are equal, then proceed further
        if(word1.charAt(i) == word2.charAt(j)) {
            dp[i][j] = minDistanceHelper(word1, word2, i+1, j+1, dp);
            return dp[i][j];
        } else {
            //Insert a char
            int op1 = 1 + minDistanceHelper(word1, word2, i, j+1, dp);
            //delete a char
            int op2 = 1 + minDistanceHelper(word1, word2, i+1, j, dp);
            //replace a char
            int op3 = 1 + minDistanceHelper(word1, word2, i+1, j+1, dp);
            dp[i][j] = Math.min(op1, Math.min(op2, op3));
            return dp[i][j];
        }
    }
    public int minDistance(String word1, String word2) {
        int[][] dp = new int[word1.length()][word2.length()];
        for(int[] row : dp)
            Arrays.fill(row, -1);

        return minDistanceHelper(word1, word2, 0, 0, dp);
    }
}