class Solution {
    public int helper(int[] prices, int i, int prevBought, int[][] dp) {
        if(i == prices.length)
            return 0;
        if(dp[i][prevBought] != -1)
            return dp[i][prevBought];
        //if stock is bought previously, then either sell today or not
        //if stock is not bought then 2 choice buy it today or not
        int profit = 0;
        if(prevBought == 1) {
            int op1 = (-prices[i] + helper(prices, i+1, 0, dp));
            int op2 = 0 + helper(prices, i+1, 1, dp);
            profit = Math.max(op1, op2);
        } else {
            //sell call
           int op1 = prices[i] + helper(prices, i+1, 1, dp);
           int op2 = 0 + helper(prices, i+1, 0, dp);
           profit = Math.max(op1, op2);
        }
        return dp[i][prevBought] = profit;
    }
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length+1][2];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return helper(prices, 0, 1, dp);
    }
}