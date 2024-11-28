class Solution {
    public int uniquePathsHelper(int i, int j, int m, int n) {
        if(i>=m || j>=n)
            return 0;
        if(i == m-1 && j == n-1) {
            return 1;
        }
        //we have two options down and right
        int down = uniquePathsHelper(i+1, j, m, n);
        int right = uniquePathsHelper(i, j+1, m, n);
        return down+right;
    }
    public int uniquePathsTopDown(int i, int j, int m, int n, int[][] dp) {
        if(i>=m || j>=n)
            return 0;
        if(i == m-1 && j == n-1) {
            return 1;
        }
        if(dp[i][j] != -1)
            return dp[i][j];
        //we have two options down and right
        int down = uniquePathsTopDown(i+1, j, m, n, dp);
        int right = uniquePathsTopDown(i, j+1, m, n, dp);
        return dp[i][j] = down+right;
    }
    public int uniquePaths(int m, int n) {
        // return uniquePathsHelper(0, 0, m, n);

        int[][] dp = new int[m+1][n+1];
        // for(int[] row : dp)
        //     Arrays.fill(row, -1);
        
        // return uniquePathsTopDown(0, 0, m, n, dp);

        //Bottom up
        //base case
        //i--> 0 to m-1
        //j--> 0 to n-1
        for (int i = 0; i < m; i++) {
            dp[i][n - 1] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[m - 1][j] = 1;
        }
        for(int i=m-2; i>=0; i--) {
            for(int j=n-2; j>=0; j--) {
                int down = dp[i+1][j];
                int right = dp[i][j+1];
                dp[i][j] = down+right;
            }
        }
        return dp[0][0];
    }
}