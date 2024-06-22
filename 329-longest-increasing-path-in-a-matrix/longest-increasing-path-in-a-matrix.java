class Solution {
    int[][] dp;
    public int helper(int i, int j, int[][] dp, int[][] matrix) {
        if(dp[i][j] != -1)
            return dp[i][j];
        
        int[] r = {0, 0, -1, 1};
        int[] c = {1,-1, 0, 0};
        dp[i][j] = 1;
        for(int k=0; k<4; k++) {
            int p = i + r[k], q = j + c[k];
            if(p<0 || q < 0 || p>=matrix.length || q>=matrix[0].length || matrix[i][j] >= matrix[p][q])
                continue;
            dp[i][j] = Math.max(dp[i][j], 1 + helper(p, q, dp, matrix));
        }
        return dp[i][j];
    }
    public int longestIncreasingPath(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        dp = new int[m+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        int res = Integer.MIN_VALUE;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                res = Math.max(res, helper(i, j, dp, matrix));
            }
        }

        return res;
    }
}