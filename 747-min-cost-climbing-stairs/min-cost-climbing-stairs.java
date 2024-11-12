class Solution {
    public int helper(int[] cost, int i) {
        if(i >= cost.length)
            return 0;
        return cost[i] + Math.min(helper(cost, i+1), helper(cost, i+2));
    }
    public int topDownhelper(int[] cost, int i, int[] dp) {
        if(i >= cost.length)
            return 0;
        
        if(dp[i] != -1)
            return dp[i];
        
        return dp[i] = cost[i] + Math.min(topDownhelper(cost, i+1, dp), topDownhelper(cost, i+2, dp));
    }
    public int minCostClimbingStairs(int[] cost) {
        //1. Recursive Sol
        // return Math.min(helper(cost, 0), helper(cost, 1));

        //2.Top Down(memoization)
        int[] dp = new int[cost.length+1];
        Arrays.fill(dp, -1);
        return Math.min(topDownhelper(cost, 0, dp), topDownhelper(cost, 1, dp));
    }
}