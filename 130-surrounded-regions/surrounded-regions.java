class Solution {
    boolean[][] vis;
    public void dfs(char[][] board, int i, int j, int m, int n) {
        if(i < 0 || i==m || j<0 || j==n || vis[i][j] == true || board[i][j] == 'X')
            return;
        vis[i][j] = true;
        //explore all four directions
        //up
        dfs(board,i-1, j, m, n);
        //down
        dfs(board, i+1, j, m, n);
        //left
        dfs(board, i, j-1, m, n);
        //right
        dfs(board, i, j+1, m, n);
    }
    public void solve(char[][] board) {
        int m = board.length;
        int n = board[0].length;
        vis = new boolean[m][n];
        for(boolean[] row : vis)
            Arrays.fill(row, false);
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                /**
                For each "0" present at boundry call dfs and mark every neighbour "0" as visited
                Coz any region which is connected with boundry 0 can not be converted to X
                Atlast those "0" which are not visited needs to be replaced with X
                 */
                if(i==0 || j==0 || i==m-1 || j==n-1) {
                    if(vis[i][j] == false && board[i][j] == 'O')
                        dfs(board, i, j, m, n);
                }
            }
        }
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(vis[i][j] == false && board[i][j] == 'O')
                    board[i][j] = 'X';
            }
        }

    }
}