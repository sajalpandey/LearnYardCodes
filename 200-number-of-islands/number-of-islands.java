class Solution {
    boolean[][] visited;
    public void dfs(int i, int j, int m, int n, char[][] grid) {
        System.out.println("i = "+i+" -- j = "+j);
        if(i<0 || j<0 || i>=m || j>=n || grid[i][j] == '0' || visited[i][j] == true)
            return;
        
        //Traverse in all four directions
        visited[i][j] = true;
        //left
        dfs(i, j-1, m, n, grid);
        //right
        dfs(i, j+1, m, n, grid);
        //up
        dfs(i-1, j, m, n, grid);
        //down
        dfs(i+1, j, m, n, grid);
    }
    public int numIslands(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        visited = new boolean[m][n];
        
        int ans = 0;
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(visited[i][j] == false && grid[i][j] == '1') {
                    ans++;
                    dfs(i,j,m ,n, grid);
                }
            }
        }

        return ans;
    }
}