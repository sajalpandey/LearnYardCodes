class Solution {
    public int robHelper1(int[] nums, int i, int[] dp) {
        if(i < 0)
            return 0;
        if(i == 0)
            return nums[0];
        if(dp[i] != -1)
            return dp[i];
        
        int takeit = nums[i] + robHelper1(nums, i-2, dp);
        int skipit = robHelper1(nums, i-1, dp);

        return dp[i] = Math.max(takeit, skipit);
    }

    public int robHelper2(int[] nums, int i, int[] dp) {
        if(i < 1)
            return 0;
        if(i == 1)
            return nums[1];

        if(dp[i] != -1)
            return dp[i];
        
        int takeit = nums[i] + robHelper2(nums, i-2, dp);
        int skipit = robHelper2(nums, i-1, dp);

        return dp[i] = Math.max(takeit, skipit);
    }
    public int rob(int[] nums) {
        //First and last are adjacent so by removing last ele we will apply previous
        //logic here from 0 to n-2

        //similarly removing first we apply similar logic from 1 to n-1
        //Max of both the answers
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int[] dp = new int[n];
        Arrays.fill(dp, -1);
        int ans1 = robHelper1(nums, n-2, dp);
        Arrays.fill(dp, -1);
        int ans2 = robHelper2(nums, n-1, dp);
        System.out.println(ans1+" -- "+ans2);
        return Math.max(ans1, ans2);
    }
}