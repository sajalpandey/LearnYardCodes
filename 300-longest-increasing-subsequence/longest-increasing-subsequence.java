class Solution {
    public int helper(int[] nums, int i, int prev) {
        if(i >= nums.length)
            return 0;
        //Now you have two choice 
        //either start fresh from ith index
        // if arr[i] > prev 1 + recursive call
        //then return max
        
        // we will take when prev == -1 Or curr ele  > prev
        int op1 = Integer.MIN_VALUE;

        if(prev == -1 || nums[i] > nums[prev])
            op1 = 1 + helper(nums, i+1, i);
        int op2 = helper(nums, i+1, prev);
        return Math.max(op1, op2);
    }

    public int helperTopDown(int[] nums, int i, int prev, int[][] dp) {
        if(i >= nums.length)
            return 0;
        if(dp[i][prev+1] != -1)
            return dp[i][prev+1];
        int op1 = Integer.MIN_VALUE;

        if(prev == -1 || nums[i] > nums[prev])
            op1 = 1 + helperTopDown(nums, i+1, i, dp);
        int op2 = helperTopDown(nums, i+1, prev, dp);
        return dp[i][prev+1]= Math.max(op1, op2);
    }
    public int lengthOfLIS(int[] nums) {
        //return helper(nums, 0, -1);
        int n = nums.length;
        int[][] dp = new int[n][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return helperTopDown(nums, 0, -1, dp);
    }
}