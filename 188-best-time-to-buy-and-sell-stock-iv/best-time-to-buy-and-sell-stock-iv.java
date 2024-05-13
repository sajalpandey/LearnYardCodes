class Solution {
    public int maxProfitHelper(int[] prices, int k, int i, int buy) {
        if(i == prices.length || k == 0)
            return 0;
        
        int profit = 0;
        if(buy == 1) {
            int buyThis = -prices[i] + maxProfitHelper(prices, k, i+1, 0);
            int skipThis = 0 + maxProfitHelper(prices, k, i+1, 1);
            profit = Math.max(buyThis, skipThis);
        } else {
            int sellThis = prices[i] + maxProfitHelper(prices, k-1, i+1, 1);
            int skipThis = 0 + maxProfitHelper(prices, k, i+1, 0);
            profit = Math.max(sellThis, skipThis);
        }

        return profit;
    }

    public int maxProfitTopDown(int[] prices, int k, int i, int buy, int[][][] dp) {
        if(i == prices.length || k == 0)
            return 0;
        if(dp[i][buy][k] != -1)
            return dp[i][buy][k];

        int profit = 0;
        if(buy == 1) {
            int buyThis = -prices[i] + maxProfitTopDown(prices, k, i+1, 0, dp);
            int skipThis = 0 + maxProfitTopDown(prices, k, i+1, 1, dp);
            profit = Math.max(buyThis, skipThis);
        } else {
            int sellThis = prices[i] + maxProfitTopDown(prices, k-1, i+1, 1, dp);
            int skipThis = 0 + maxProfitTopDown(prices, k, i+1, 0, dp);
            profit = Math.max(sellThis, skipThis);
        }

        return dp[i][buy][k] = profit;
    }

    public int maxProfitBottomUp(int[] prices, int K) {
        int n = prices.length;
        int[][][] dp = new int[n+1][2][K+1];

        for(int i=n-1; i>=0; i--) {
            for(int buy=0; buy<=1; buy++) {
                for(int k=1; k<=K; k++) {
                    int profit = 0;
                    if(buy == 1) {
                        int buyThis = -prices[i] + dp[i+1][0][k];
                        int skipThis = 0 + dp[i+1][1][k];
                        profit = Math.max(buyThis, skipThis);
                    } else {
                        int sellThis = prices[i] + dp[i+1][1][k-1];
                        int skipThis = 0 + dp[i+1][0][k];
                        profit = Math.max(sellThis, skipThis);
                    }
                    dp[i][buy][k] = profit;
                }
            }
        }

        return dp[0][1][K];
    }
    public int maxProfit(int k, int[] prices) {
        //1. Recursion
        //return maxProfitHelper(prices, k, 0, 1);

        //2. DP Top Down
        // int n = prices.length;
        // int[][][] dp = new int[n][2][k+1];
        // for(int[][] matrix : dp)
        //     for(int[] row : matrix)
        //         Arrays.fill(row, -1);
        // return maxProfitTopDown(prices, k, 0, 1, dp);

        //3. DP Bottom Up
        return maxProfitBottomUp(prices, k);
    }
}