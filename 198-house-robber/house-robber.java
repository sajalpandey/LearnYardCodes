class Solution {
    public int helper(int[] nums, int i, int[] dp) {
        if(i >= nums.length) {
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];

        //Robber choose to rob this house, then he can rob to next to next house
        int sum1 = nums[i] + helper(nums, i+2, dp);
        
        //Robber decided not to rob this house. then he can rob to next house
        int sum2 = helper(nums, i+1, dp);
        dp[i] = Math.max(sum1, sum2);
        return dp[i];
    }
    public int rob(int[] nums) {
        int n = nums.length;
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);

        //Recursion + memoisation =  TOP DOWN APPRAOCH
        //return helper(nums,0,dp);

        //BOTTOM UP APPROACH
        dp[0] = 0;
        dp[1] = nums[0];
        for(int i=2; i<=n; i++) {
            int val = nums[i-1];
            dp[i] = Math.max(val + dp[i-2], dp[i-1]);
        }
        return dp[n];
    }
    /**
    Recursion time complexity os O(2^n) & SC: O(2^n)
     */
}