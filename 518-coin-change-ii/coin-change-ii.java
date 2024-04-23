class Solution {
    public int changeHelper(int[] coins, int i, int amount, int[][] dp) {
        if(amount < 0)
            return 0;
        if(i >= coins.length) {
            if(amount == 0)
                return 1;
            return 0;
        }

        if(dp[i][amount] != -1)
            return dp[i][amount];

        // when we are picking that coin
        int ans1 = 0;
        ans1 += changeHelper(coins, i, amount-coins[i], dp);

        int ans2 = 0;
        ans2 += changeHelper(coins, i+1, amount, dp);

        dp[i][amount] =  ans1 + ans2;
        return dp[i][amount]; 
    }
    public int change(int amount, int[] coins) {
        int[][] dp = new int[coins.length+1][amount+2];
        //dp[1] = 1;
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return changeHelper(coins, 0, amount, dp);
    }
}