class Solution {
    public int maxProfitTopDown(int[] prices, int i, int buy, int fee, int[][] dp) {
        if(i == prices.length)
            return 0;
        
        if(dp[i][buy] != -1)
            return dp[i][buy]; 
        int profit = 0;
        if(buy == 1) {
            int buyThis = -prices[i] + maxProfitTopDown(prices, i+1, 0, fee, dp);
            int skipThis = 0 + maxProfitTopDown(prices, i+1, 1, fee, dp);
            profit = Math.max(buyThis, skipThis);
        } else {
            int sellThis = +prices[i] - fee + maxProfitTopDown(prices, i+1, 1, fee, dp);
            int skipThis = 0 +  maxProfitTopDown(prices, i+1, 0, fee, dp);
            profit = Math.max(sellThis, skipThis);
        }
        return dp[i][buy] = profit;
    }

    public int maxProfitBottomUp(int[] prices, int fee) {
        int n = prices.length;
        int[][] dp = new int[n+1][2];

        for(int i=n-1; i>=0; i--) {
            for(int buy=0; buy<=1; buy++) {
                int profit = 0;
                if(buy == 1) {
                    int buyThis = -prices[i] + dp[i+1][0];
                    int skipThis = 0 + dp[i+1][1];
                    profit = Math.max(buyThis, skipThis);
                } else {
                    int sellThis = +prices[i] - fee + dp[i+1][1];
                    int skipThis = 0 +  dp[i+1][0];
                    profit = Math.max(sellThis, skipThis);
                }
                dp[i][buy] = profit;
            }
        }
        return dp[0][1];
    }
    public int maxProfit(int[] prices, int fee) {

        //1. DP Top Down
        // int n = prices.length;
        // int[][] dp = new int[n+1][2];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return maxProfitTopDown(prices, 0, 1, fee, dp);

        //2. DP Bottom Up
        return maxProfitBottomUp(prices, fee);
    }
}