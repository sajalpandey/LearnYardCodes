class Solution {
    public int helper(int n) {
        if(n <= 2)
            return n;
        return (helper(n-1) + helper(n-2));
    }
    public int topDownHelper(int n, int[] dp) {
        if(n <= 2)
            return n;
        if(dp[n] != -1)
            return dp[n];
        
        return dp[n] = topDownHelper(n-1, dp) + topDownHelper(n-2, dp);
    }
    public int climbStairs(int n) {
        //1. Recursion|| TC: O(n) || SC:O(n)
        //return helper(n);

        //2.Memoization(Top Down)
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return topDownHelper(n, dp);
    }
}