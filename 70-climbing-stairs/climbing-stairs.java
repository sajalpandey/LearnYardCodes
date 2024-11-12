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
        //1. Recursion|| TC: O(2^n) || SC:O(n) 
        //return helper(n);

        //2.Memoization(Top Down)|| TC: O(n) || SC:O(n)
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return topDownHelper(n, dp);

        //3. Bottom Up(Iterative)|| TC: O(n) || SC:O(n)
        // if(n <= 2)
        //     return n;
        // int[] dp = new int[n+1];
        // dp[1] = 1; dp[2] = 2;
        // for(int i=3; i<=n; i++)
        //     dp[i] = dp[i-1] + dp[i-2];
        // return dp[n];

        //4. Space optimized
        if(n <= 2)
            return n;
        int prev2 = 1, prev = 2, curr = 0;
        for(int i=3; i<=n; i++) {
            curr = prev + prev2;
            prev2 = prev;
            prev = curr;
        }
        return curr;
    }
}