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

    public int helper2(int[] nums, int i, int[] dp) {
        if(i >= nums.length - 1) {
            return 0;
        }
        if(dp[i] != -1)
            return dp[i];

        //Robber choose to rob this house, then he can rob to next to next house
        int sum1 = nums[i] + helper2(nums, i+2, dp);
        
        //Robber decided not to rob this house. then he can rob to next house
        int sum2 = helper2(nums, i+1, dp);
        dp[i] = Math.max(sum1, sum2);
        return dp[i];
    }
    public int rob(int[] nums) {
        if(nums.length == 1)
            return nums[0];
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp, -1);
        int op1 = helper(nums, 1, dp);
        Arrays.fill(dp, -1);
        int op2 = helper2(nums, 0, dp);
        return Math.max(op1, op2);
    }
}