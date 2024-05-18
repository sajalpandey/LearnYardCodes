class Solution {
    public int minimumTotalHelper(List<List<Integer>> triangle, int i, int j, int m) {
        if(i >= m || i < m && j >= triangle.get(i).size())
            return 0;

        //we have two choices either to take jth index or j+1th index

        int op1 = triangle.get(i).get(j) + minimumTotalHelper(triangle, i+1, j, m);
        int op2 = triangle.get(i).get(j) + minimumTotalHelper(triangle, i+1, j+1, m);

        return Math.min(op1, op2);
    }

    public int minimumTotalTopDown(List<List<Integer>> triangle, int i, int j, int m, int[][] dp) {
        if(i >= m || i < m && j >= triangle.get(i).size())
            return 0;

        if(dp[i][j] != -1)
            return dp[i][j];
        //we have two choices either to take jth index or j+1th index

        int op1 = triangle.get(i).get(j) + minimumTotalTopDown(triangle, i+1, j, m, dp);
        int op2 = triangle.get(i).get(j) + minimumTotalTopDown(triangle, i+1, j+1, m, dp);

        return dp[i][j] = Math.min(op1, op2);
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int m = triangle.size();
        //1. Recursion
        //return minimumTotalHelper(triangle, 0, 0, m);

        //2. DP Top Down
        int[][] dp = new int[m+1][m+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return minimumTotalTopDown(triangle, 0, 0, m, dp);
    }
}