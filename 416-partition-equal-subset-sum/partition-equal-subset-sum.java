class Solution {
    public boolean canPartitionHelper(int[] nums, int i, int sum1, int sum2) {
        if(i == nums.length) {
            return sum1 == sum2;
        }

        //Two choices
        //add current ele to sum1 or add to sum2
        return (canPartitionHelper(nums, i+1, sum1+nums[i], sum2) || canPartitionHelper(nums, i+1, sum1, sum2+nums[i]));
    }
    public boolean canPartitionBottomUp(int[] arr, int sum){
        int N = arr.length;
        boolean[][] dp = new boolean[N+1][sum + 1];
        for(int i=0; i<=N; i++)
            dp[i][0] = true;
        
        for(int i=N-1; i>=0; i--) {
            for(int target = 0; target<=sum; target++) {
                if(target >= arr[i])
                    dp[i][target] = dp[i+1][target - arr[i]];
                dp[i][target] = dp[i][target] || dp[i+1][target];
            }
        }
        return dp[0][sum];
    }
    public boolean canPartition(int[] nums) {
        int totalSum = 0;
        for(int ele : nums)
            totalSum += ele;
        if(totalSum %2 != 0)
            return false;
        return canPartitionBottomUp(nums, totalSum/2);
        //return canPartitionHelper(nums, 0, 0, 0);
    }
}