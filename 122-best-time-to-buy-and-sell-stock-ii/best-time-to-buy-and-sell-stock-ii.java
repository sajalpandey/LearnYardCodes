class Solution {
    public int maxProfitHelper(int[] prices, int i, int buy) {
        if(i == prices.length)
            return 0;
        
        int profit = 0;
        if(buy == 1) {
            //Its a buy call , we can buy or skip
            int buyThis = (-prices[i] + maxProfitHelper(prices, i+1, 0));
            int skipThis = (0 + maxProfitHelper(prices, i+1, 1));
            profit = Math.max(buyThis, skipThis);
        } else {
            //Its a sell call, we can sell of skip 
            int sellThis = (+prices[i] + maxProfitHelper(prices, i+1, 1));
            int skipThis = (0 + maxProfitHelper(prices, i+1, 0));
            profit = Math.max(sellThis, skipThis);
        }
        return profit;
    }

    public int maxProfitTopDown(int[] prices, int i, int buy, int[][] dp) {
        if(i == prices.length)
            return 0;
        
        if(dp[i][buy] != -1)
            return dp[i][buy];

        int profit = 0;
        if(buy == 1) {
            //Its a buy call , we can buy or skip
            int buyThis = (-prices[i] + maxProfitTopDown(prices, i+1, 0, dp));
            int skipThis = (0 + maxProfitTopDown(prices, i+1, 1, dp));
            profit = Math.max(buyThis, skipThis);
        } else {
            //Its a sell call, we can sell of skip 
            int sellThis = (+prices[i] + maxProfitTopDown(prices, i+1, 1, dp));
            int skipThis = (0 + maxProfitTopDown(prices, i+1, 0, dp));
            profit = Math.max(sellThis, skipThis);
        }
        return dp[i][buy] = profit;
    }

    public int maxProfit(int[] prices) {
        //1. Recursion
        //return maxProfitHelper(prices, 0, 1);

        //2. DP Top Down
        int n = prices.length;
        int[][] dp = new int[n][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return maxProfitTopDown(prices, 0, 1, dp);
    }
}