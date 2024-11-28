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
        for(int[] row : dp)
            Arrays.fill(row, -1);
        
        return uniquePathsTopDown(0, 0, m, n, dp);
    }
}