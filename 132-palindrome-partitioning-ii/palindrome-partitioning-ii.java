class Solution {
    public int isPal(String s, int i, int j, int[][] dp1) {
        if(i >= j) {
            return 1;
        }
        if(dp1[i][j] != -1)
            return dp1[i][j];
        int ans = 0;
        if(s.charAt(i) == s.charAt(j)) {
            ans = isPal(s, i+1, j-1, dp1);
        } else {
            ans = 0;
        }
        dp1[i][j] = ans;
        return dp1[i][j];
    }
    // public int minCutHelper(int i, String s) {
    //     if(i >= s.length() || isPal(s, i, s.length()-1) == 1)
    //         return 0;
        
    //     //We need to start taking cut if string is plindrome then proceed further recursive calls
    //     int minimumCut = Integer.MAX_VALUE, partialAns = Integer.MAX_VALUE;
    //     for(int k=i; k<s.length(); k++) {
    //         if(isPal(s, i, k) == 1) {
    //             partialAns = (1 + minCutHelper(k+1, s));
    //         }
    //         minimumCut = Math.min(minimumCut, partialAns);
    //     }
    //     return minimumCut;
    // }
    public int minCutTopDown(int i, String s, int[] dp, int[][] dp1) {
        if(i >= s.length() || isPal(s, i, s.length()-1, dp1) == 1)
            return 0;
        if(dp[i] != -1)
            return dp[i];

        //We need to start taking cut if string is plindrome then proceed further recursive calls
        dp[i] = Integer.MAX_VALUE;
        for(int k=i; k<s.length(); k++) {
            if(isPal(s, i, k, dp1) == 1) {
                dp[i] = Math.min(dp[i], 1 + minCutTopDown(k+1, s, dp, dp1));
            }
        }
        return dp[i];
    }
    public int minCut(String s) {
        //DP to check palindrome
        int n = s.length();
        int[][] dp1 = new int[n][n];
        for(int[] row : dp1)
            Arrays.fill(row, -1);
        isPal(s, 0, n-1, dp1);

        //1. Recursive
        // return minCutHelper(i, s);
        //Dp for minCut
        //2. Top Down
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        return minCutTopDown(0, s, dp, dp1);

    }
}