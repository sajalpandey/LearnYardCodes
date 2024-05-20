class Solution {
    public int minFallingPathSumHelper(int[][] matrix, int row, int col) {
        if(col >= matrix[0].length || col < 0) {
            return Integer.MAX_VALUE;
        }
        if(row >= matrix.length)
            return 0;
        //from here we have 3 options
        //down left 
        int op1 = minFallingPathSumHelper(matrix, row+1, col-1);
        //straight down
        int op2 = minFallingPathSumHelper(matrix, row+1, col);
        //down right
        int op3 = minFallingPathSumHelper(matrix, row+1, col+1);

        return matrix[row][col] + Math.min(op1, Math.min(op2, op3));
    }

    public int minFallingPathSumTopDown(int[][] matrix, int row, int col, int[][] dp) {
        if(col >= matrix[0].length || col < 0) {
            return Integer.MAX_VALUE;
        }
        if(row >= matrix.length)
            return 0;
        if(dp[row][col] != Integer.MAX_VALUE)
            return dp[row][col];
        //from here we have 3 options
        //down left 
        int op1 = minFallingPathSumTopDown(matrix, row+1, col-1, dp);
        //straight down
        int op2 = minFallingPathSumTopDown(matrix, row+1, col, dp);
        //down right
        int op3 = minFallingPathSumTopDown(matrix, row+1, col+1, dp);

        return dp[row][col] = matrix[row][col] + Math.min(op1, Math.min(op2, op3));
    }
    public int minFallingPathSum(int[][] matrix) {

        //1. Recursive
        // int ans = Integer.MAX_VALUE;
        // for(int j=0; j<matrix[0].length; j++) {
        //     ans = Math.min(ans, minFallingPathSumHelper(matrix, 0, j));
        //     System.out.println(matrix[0][j]+" -- "+ans);
        // }
        // return ans;

        //2. DP Top Down
        int[][] dp = new int[matrix.length][matrix.length];
        for(int[] row : dp)
            Arrays.fill(row, Integer.MAX_VALUE);
        int ans = Integer.MAX_VALUE;
        for(int j=0; j<matrix[0].length; j++) {
            ans = Math.min(ans, minFallingPathSumTopDown(matrix, 0, j, dp));
        }
        return ans;
    }
}