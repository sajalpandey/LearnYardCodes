class Solution {
    public long maximumTotalCostHelper(int[] nums, int i, int flag, long[][] dp) {
        if(i >= nums.length)
            return 0;
        if(dp[i][flag] != Long.MIN_VALUE)
            return dp[i][flag];
        
        //We have two choices now
        //First to include the element in current subarray
        //else start a new subarray from here

        long startNew = 0, includePrev = 0;
        //When you start new subarray you need to add nums[i] as its to ans and call recursion
        startNew = nums[i] + maximumTotalCostHelper(nums, i+1, 0, dp);

        //include this element in previous subarrays means 
        //it will depend on flag value
        if(flag == 1)
            includePrev = nums[i] + maximumTotalCostHelper(nums, i+1, 0, dp);
        else
            includePrev = nums[i] * -1 + maximumTotalCostHelper(nums, i+1, 1, dp);
        
        return dp[i][flag] = Math.max(startNew, includePrev);

    }
    public long maximumTotalCost(int[] nums) {
        int n = nums.length;
        long[][] dp = new long[n+1][2];
        for(long[] row : dp)
            Arrays.fill(row, Long.MIN_VALUE);
        return maximumTotalCostHelper(nums, 0, 1, dp);
    }
}