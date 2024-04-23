class Solution {
    public int climbStairsHelper(int n, int[] dp) {
        if(n <= 2)
            return n;
        
        if(dp[n] != -1)
            return dp[n];

        int steps = climbStairsHelper(n-1, dp) + climbStairsHelper(n-2, dp);
        dp[n] = steps;
        return dp[n];
    }
    public int climbStairs(int n) {
        if(n <= 2)
            return n;
        //Recursion + memoisation =  TOP DOWN APPRAOCH
        int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return climbStairsHelper(n, dp);

        //BOTTOM UP APPROACH
        dp[1] = 1;
        dp[2] = 2;

        for(int i=3; i<=n; i++)
            dp[i] = dp[i-1] + dp[i-2];
        return dp[n];
    }
}