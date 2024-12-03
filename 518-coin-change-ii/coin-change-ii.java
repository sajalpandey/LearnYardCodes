class Solution {
    public int helper(int[] coins, int amount, int i) {
        if(amount == 0)
            return 1;
        if(i >= coins.length) {
            return (amount == 0 ? 1 : 0);
        }
        // weh have two choices
        //either to include it or not
        int op1 = 0, op2 = 0;
        if(amount-coins[i] >= 0)
            op1 = helper(coins, amount-coins[i], i);
        op2 = helper(coins, amount, i+1);
        return op1+op2;
    }

    public int helperTopDown(int[] coins, int amount, int i, int[][] dp) {
        if(amount == 0)
            return 1;
        if(i >= coins.length) {
            return (amount == 0 ? 1 : 0);
        }
        if(dp[amount][i] != -1)
            return dp[amount][i];
        // weh have two choices
        //either to include it or not
        int op1 = 0, op2 = 0;
        if(amount-coins[i] >= 0)
            op1 = helperTopDown(coins, amount-coins[i], i, dp);
        op2 = helperTopDown(coins, amount, i+1, dp);
        return dp[amount][i] = op1+op2;
    }
    public int change(int amount, int[] coins) {
        //return helper(coins, amount, 0);
        if(amount == 0)
            return 1;
        int[][] dp = new int[amount+1][coins.length+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        
        // return helperTopDown(coins, amount, 0, dp);

        //Bottom Up 
        //amount from amount to 0
        //i from 0 to n

        //base case amount = 0 , for every i 
        
        for(int t = 0; t<=amount; t++) {
            for(int i=coins.length-1; i>=0; i--) {
                dp[0][i] = 1;
                int op1 = 0, op2 = 0;
                if(t-coins[i] >= 0)
                    op1 = dp[t-coins[i]][i];
                op2 = dp[t][i+1];
                dp[t][i] = op1+op2;
            }
        }

        return dp[amount][0];
    }
}