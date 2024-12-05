class Solution {
    public boolean helper(String s1, String s2, String s3, int i, int j, int k) {
        if(k == s3.length()) {
            if(i == s1.length() && j == s2.length())
                return true;
            return false;
        }
        // we need to explore every way , if char matches in both strings
        boolean res1 = false, res2 = false;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k))
            res1 = helper(s1,s2, s3, i+1, j, k+1);
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k))
            res2 = helper(s1, s2, s3, i, j+1, k+1);
        
        return (res1 || res2);

    }

    public int helperTopDown(String s1, String s2, String s3, int i, int j, int[][] dp) {
        if((i+j) == s3.length()) {
            if(i == s1.length() && j == s2.length())
                return 1;
            return 0;
        }
        if(dp[i][j] != -1)
            return dp[i][j];

        // we need to explore every way , if char matches in both strings
        int res1 = 0, res2 = 0;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(i+j))
            res1 = helperTopDown(s1,s2, s3, i+1, j, dp);
        if(j < s2.length() && s2.charAt(j) == s3.charAt(i+j))
            res2 = helperTopDown(s1, s2, s3, i, j+1, dp);
        
        return dp[i][j] = (res1 + res2) >= 1 ? 1 : 0;

    }
    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length())
            return false;
        /**
        we try to match char from s3 to s1 and s2 and move on
        if both contains same char as s3 then go in both dir to match
         */
        
        // return helper(s1, s2, s3, 0, 0, 0);

        /**
        For k , k is nothing but (i+j)
        so we can avoid using k
         */
        int[][] dp = new int[s1.length()+1][s2.length()+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return helperTopDown(s1,s2, s3, 0, 0, dp) == 1 ? true : false;

        //Bottom up
        //i o to s1.length
        //j o to s2.length
        //base condition
        dp[s1.length()][s2.length()] = 1;
        for(int i=s1.length(); i>=0; i--) {
            for(int j=s2.length(); j>=0; j--) {
                if (i < s1.length() && s1.charAt(i) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] | dp[i + 1][j]; // If match, carry forward the state
                }
                // Check if s2[j] matches s3[i+j]
                if (j < s2.length() && s2.charAt(j) == s3.charAt(i + j)) {
                    dp[i][j] = dp[i][j] | dp[i][j + 1]; // If match, carry forward the state
                }
            }
        }
        return dp[0][0] == 1;
    }
}