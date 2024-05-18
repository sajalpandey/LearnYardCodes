class Solution {
    public int minPathSumTopDown(int[][] grid, int i, int j, int m, int n, int[][] dp) {
        if(i >= m || j >= n)
            return Integer.MAX_VALUE;
        if(i == m-1 && j == n-1)
            return grid[i][j];
        
        if(dp[i][j] != -1)
            return dp[i][j];
        int minSum = Integer.MAX_VALUE;

        //we have two choices, either go down or go right
        minSum = grid[i][j] + Math.min(minPathSumTopDown(grid, i, j+1, m, n, dp), minPathSumTopDown(grid, i+1, j, m, n, dp));
        return dp[i][j] = minSum;
    }

    public int minPathSumBottomUp(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m+1][n+1];
        dp[m-1][n-1] = grid[m-1][n-1];
        //we also need to fill last row and column
        //as from last row we can move right only
        //from last column we can move down only

        for(int i=m-2; i>=0; i--) {
            dp[i][n-1] = grid[i][n-1] + dp[i+1][n-1];
        }

        for(int i=n-2; i>=0; i--)
            dp[m-1][i] = grid[m-1][i] + dp[m-1][i+1];

        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                int minSum = Integer.MAX_VALUE;
                //we have two choices, either go down or go right
                minSum = grid[i][j] + Math.min(dp[i][j+1], dp[i+1][j]);
                dp[i][j] = minSum;
            }
        }
        return dp[0][0];
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        //1.Recursion
        //return minPathSumHelper(grid, 0, 0, m, n);

        //2. DP Top Down
        // int[][] dp = new int[m+1][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        // return minPathSumTopDown(grid, 0, 0, m, n, dp);

        //3. DP Bottom Up
        return minPathSumBottomUp(grid);
    }
}