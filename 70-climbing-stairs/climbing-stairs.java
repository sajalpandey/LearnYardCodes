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
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return climbStairsHelper(n, dp);
    }
}