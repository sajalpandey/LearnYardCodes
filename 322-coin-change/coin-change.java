class Solution {
    public int coinChangeHelper(int[] coins, int amount, int i, int count) {
        if(amount == 0) {
            return count;
        }
        if(i < 0 || amount < 0) {
            return -1;
        }
        // we will have two choices either take the curren coin or not
        int count1 = coinChangeHelper(coins, amount-coins[i], i, count+1);
        int count2 = coinChangeHelper(coins, amount, i-1, count);
        return Math.min(count1, count2);
    }
    public int coinChangeMemo(int[] coins, int amount, int i, int[][] dp) {
        if(amount == 0) {
            return 0;
        }
        if(i < 0 || amount < 0) {
            return Integer.MAX_VALUE;
        }
        if(dp[i][amount] != -1)
            return dp[i][amount];

        // we will have two choices either take the curren coin or not
        int count2 = coinChangeMemo(coins, amount, i-1, dp);
        int count1 = Integer.MAX_VALUE;
        if(coins[i] <= amount)
            count1 = coinChangeMemo(coins, amount-coins[i], i, dp);
        count1 = count1 ==Integer.MAX_VALUE ? count1 : ++count1;
        return dp[i][amount] = Math.min(count1, count2);
    }
    public int coinChange(int[] coins, int amount) {
        //1. Recursion TC: (2^n)
        int n = coins.length;
        Arrays.sort(coins);
        //return coinChangeHelper(coins, amount, n-1, 0);

        //2. Top Down
        // int[][] dp = new int[n][amount+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // int result = coinChangeMemo(coins, amount, n-1, dp);
        // return result == Integer.MAX_VALUE ? -1 : result;


        //3. Bottom Up
        int[][] dp = new int[n][amount+1];
        for(int[] row : dp)
            Arrays.fill(row, 0);
        
        for(int i=0; i<n; i++) {
            for(int t = 1; t<=amount; t++) {
                int count2 = Integer.MAX_VALUE;
                if(i-1 >= 0)
                    count2 = dp[i-1][t];

                int count1 = Integer.MAX_VALUE;
                if(coins[i] <= t)
                    count1 = dp[i][t-coins[i]];
                count1 = count1 ==Integer.MAX_VALUE ? count1 : ++count1;

                dp[i][t] = Math.min(count1, count2);
            }
        }

        return dp[n-1][amount] == Integer.MAX_VALUE ? -1 : dp[n-1][amount];
    }
}