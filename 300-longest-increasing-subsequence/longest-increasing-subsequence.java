class Solution {
    public int lengthOfLISHelper(int[] nums, int i, int prev) {
        if(i == nums.length) 
            return 0;
        
        //If the current ele is greater than previous selected then 
        //increase ans , update prev and call recursion
        int op1 = 0;
        int op2 = 0, op3 = 0;
        if(prev == -1 || nums[i] > nums[prev]) {
            op1 = 1 + (lengthOfLISHelper(nums, i+1, i));
        }
        //move ahead in serach of greater ele than previous
        op2 = lengthOfLISHelper(nums, i+1, prev);
    
        int ans = Math.max(op1, op2);
        //Else the current ele <= previous selected 
        //We have two choice start a fresh sequence from here
        //OR increase i only 
        return ans;
        
    }

    public int lengthOfLISTopDown(int[] nums, int i, int prev, int[][] dp) {
        if(i == nums.length) 
            return 0;
        
        if(dp[i][prev+1] != -1)
            return dp[i][prev+1];

        //If the current ele is greater than previous selected then 
        //increase ans , update prev and call recursion
        int op1 = 0;
        int op2 = 0, op3 = 0;
        if(prev == -1 || nums[i] > nums[prev]) {
            op1 = 1 + (lengthOfLISTopDown(nums, i+1, i, dp));
        }
        //move ahead in serach of greater ele than previous
        op2 = lengthOfLISTopDown(nums, i+1, prev, dp);
    
        dp[i][prev+1] = Math.max(op1, op2);
        //Else the current ele <= previous selected 
        //We have two choice start a fresh sequence from here
        //OR increase i only 
        return dp[i][prev+1];
        
    }
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        if(n < 2)
            return 1;

        //1. Recursive TC: (2^n) & SC: (n)
        //return lengthOfLISHelper(nums, 0, -1);

        //2. DP TOP Down 
        // int[][] dp = new int[n+1][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return lengthOfLISTopDown(nums, 0, -1, dp);

        //3. DP Bottom Up
        int[][] dp = new int[n+1][n+1];

        for(int prev = 0; prev<=n; prev++)
            dp[n][prev] = 0;
        
        for(int i=n-1; i>=0; i--) {
            for(int prev=i-1; prev>=-1; prev--) {
                int op1 = 0;
                int op2 = 0;
                if(prev == -1 || nums[i] > nums[prev]) {
                    op1 = 1 + (dp[i+1][i+1]);
                }
                //move ahead in serach of greater ele than previous
                op2 = dp[i+1][prev+1];
            
                dp[i][prev+1] = Math.max(op1, op2);
            }
        }

        return dp[0][0];
    }
}