class Solution {
    public void dfs(int[][] grid, boolean[][] vis, int i, int j, int m, int n) {
        if(i<0 || j<0 || i>=m || j>=n || vis[i][j]==true || grid[i][j]==0)
            return;
        vis[i][j] = true;
        //visit all 4 directions
        dfs(grid, vis, i-1, j, m, n);
        dfs(grid, vis, i+1, j, m, n);
        dfs(grid, vis, i, j-1, m, n);
        dfs(grid, vis, i, j+1, m, n);
    }
    public int numEnclaves(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        for(boolean[] row : vis)
            Arrays.fill(row, false);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //if we are on boundry and its a land and unvisited
                if(i==0 || j==0 || i==m-1 || j==n-1 && (grid[i][j]==1 && vis[i][j]==false)) {
                    dfs(grid, vis, i, j, m, n);
                }
            }
        }
        int count = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(grid[i][j] == 1 && vis[i][j] == false)
                    count++;
            }
        }

        return count;
    }
}