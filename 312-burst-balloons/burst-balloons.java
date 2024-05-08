class Solution {
    public int maxCoinsHelper(int[] nums, int i, int j) {
        if(i > j)
            return 0;
        
        int maxAns = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++) {
            int currCoins = nums[k] * ((i-1 >= 0) ? nums[i-1] : 1) * ((j+1 < nums.length) ? nums[j+1] : 1);
            int ans = maxCoinsHelper(nums, i, k-1) + maxCoinsHelper(nums, k+1, j) + currCoins;
            maxAns = Math.max(maxAns, ans);
        }
        return maxAns;
    }
    public int maxCoinsTopDown(int[] nums, int i, int j, int[][] dp) {
        if(i > j)
            return 0;
        if(dp[i][j] != -1)
            return dp[i][j];

        int maxAns = Integer.MIN_VALUE;
        for(int k=i; k<=j; k++) {
            int currCoins = nums[k] * ((i-1 >= 0) ? nums[i-1] : 1) * ((j+1 < nums.length) ? nums[j+1] : 1);
            int ans = maxCoinsTopDown(nums, i, k-1, dp) + maxCoinsTopDown(nums, k+1, j, dp) + currCoins;
            maxAns = Math.max(maxAns, ans);
        }
        return dp[i][j] = maxAns;
    }
    public int maxCoins(int[] nums) {
        //1. Recursion
        // return maxCoinsHelper(nums, 0, nums.length-1);

        //2. DP Top Down
        int n = nums.length;
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return maxCoinsTopDown(nums, 0, nums.length-1, dp);
    }
}