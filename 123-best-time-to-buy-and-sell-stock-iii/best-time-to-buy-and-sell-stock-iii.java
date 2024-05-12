class Solution {
    public int maxProfitHelper(int[] prices, int i, int buy, int count) {
        if(i == prices.length || count == 2)
            return 0;
        
        int profit = 0;
        if(buy == 1) {
            int takeThis = -prices[i] + maxProfitHelper(prices, i+1, 0, count);
            int skipThis = 0 + maxProfitHelper(prices, i+1, 1, count);
            profit = Math.max(takeThis, skipThis);
        } else {
            int sellThis = prices[i] + maxProfitHelper(prices, i+1, 1, count+1);
            int skipThis = 0 + maxProfitHelper(prices, i+1, 0, count);
            profit = Math.max(sellThis, skipThis);
        }
        return profit;
    }

    public int maxProfitTopDown(int[] prices, int i, int buy, int count, int[][][] dp) {
        if(i == prices.length || count == 2)
            return 0;
        
        if(dp[i][buy][count] != -1)
            return dp[i][buy][count];

        int profit = 0;
        if(buy == 1) {
            int takeThis = -prices[i] + maxProfitTopDown(prices, i+1, 0, count, dp);
            int skipThis = 0 + maxProfitTopDown(prices, i+1, 1, count, dp);
            profit = Math.max(takeThis, skipThis);
        } else {
            int sellThis = prices[i] + maxProfitTopDown(prices, i+1, 1, count+1, dp);
            int skipThis = 0 + maxProfitTopDown(prices, i+1, 0, count, dp);
            profit = Math.max(sellThis, skipThis);
        }
        return dp[i][buy][count] = profit;
    }

    public int maxProfitBottomUp(int[] prices){
        int n = prices.length;
        int[][][] dp = new int[n+1][2][3];

        for(int i=n-1; i>=0; i--) {
            for(int buy=0; buy<=1; buy++) {
                for(int count=1; count>=0; count--) {
                    int profit = 0;
                    if(buy == 1) {
                        int takeThis = -prices[i] + dp[i+1][0][count];
                        int skipThis = 0 + dp[i+1][1][count];
                        profit = Math.max(takeThis, skipThis);
                    } else {
                        int sellThis = prices[i] + dp[i+1][1][count+1];
                        int skipThis = 0 + dp[i+1][0][count];
                        profit = Math.max(sellThis, skipThis);
                    }
                    dp[i][buy][count] = profit;
                }
            }
        }
        return dp[0][1][0];
    }
    public int maxProfit(int[] prices) {
        //1. Recursion
        //return maxProfitHelper(prices, 0, 1, 0);

        //2. DP Top Down
        // int n = prices.length;
        // int[][][] dp = new int[n][2][3];
        // for(int[][] matrix : dp)
        //     for(int[] row : matrix)
        //         Arrays.fill(row, -1);
        // return maxProfitTopDown(prices, 0, 1, 0, dp);

        return maxProfitBottomUp(prices);
    }
}