class Solution {
    public boolean canPartitionHelper(int[] nums, int i, int sum1, int sum2) {
        if(i >= nums.length) {
            return (sum1 == sum2 ? true : false);
        }

        //we have 2 choice for each ele
        //either to add in sum1 or sum2
        boolean op1 = canPartitionHelper(nums, i+1, sum1+nums[i], sum2);

        boolean op2 = canPartitionHelper(nums, i+1, sum1, sum2+nums[i]);

        return (op1 || op2);
    }
    public int canPartitionTopDown(int[] nums, int i, int target, int[][] dp) {
        if(target == 0)
            return 1;
        if(i >= nums.length) {
            if(target == 0)
                return 1;
            return 0;
        }
        if(dp[i][target] != -1)
            return dp[i][target];
        // we have two options
        //either do not take this ele in subset
        // or if target-ele > 0 take it
        int op1 = canPartitionTopDown(nums, i+1, target, dp);
        int op2 = 0;
        if(target-nums[i] >= 0)
            op2 = canPartitionTopDown(nums, i+1, target-nums[i], dp);
        return dp[i][target] = (op1 + op2 > 0 ? 1 : 0);
    }
    public boolean canPartition(int[] nums) {
        int n = nums.length;
        int sum = 0;
        for(int ele : nums)
            sum += ele;
        
        if(sum % 2 != 0)
            return false;
        //return canPartitionHelper(nums, 0, 0, 0);
        /**
        For dp we can thing like searching a subset of sum/2
         */
        int[][] dp = new int[n+1][sum/2+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        
        // return canPartitionTopDown(nums, 0, sum/2, dp) == 1 ? true : false;

        //Now changing it to Bottom up
        //base case , when target is 0 dp[i][target] = 1
        //changing parameters
        // i --> 0 to n-1
        //target --> sum/2 to 0
        //reverse them
        for(int i=n; i>=0; i--) {
            dp[i][0] = 1; 
        }
        for(int i=n-1; i>=0; i--) {
            for(int target=0; target<=sum/2; target++) {
                //copy the recusion calls
                int op1 = dp[i+1][target];
                int op2 = 0;
                if(target-nums[i] >= 0)
                    op2 = dp[i+1][target-nums[i]];
                dp[i][target] = (op1 + op2 > 0 ? 1 : 0);
            }
        }
        return dp[0][sum/2]==1 ? true: false;
    }
}