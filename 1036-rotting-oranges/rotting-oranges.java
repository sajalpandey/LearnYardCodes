class Pair {
    int row;
    int col;
    int time;
    Pair(int i, int j, int t) {
        this.row = i;
        this.col = j;
        this.time = t;
    }
}
class Solution {
    public int orangesRotting(int[][] grid) {
        //This is MULTI SOURCE BFS QUESTION
        int m = grid.length;
        int n =grid[0].length;

        Queue<Pair> qq = new LinkedList<>();
        int[][] vis = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                //Add all rotten orange as source of BFS with co-ordinates and time as 0
                if(grid[i][j] == 2) {
                    qq.add(new Pair(i,j,0));
                    //mark visited
                    vis[i][j] = 2;
                } else if(grid[i][j] == 1)
                    vis[i][j] = 1;
            }
        }

        //Now start BFS
        int ans = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        while(!qq.isEmpty()) {
            Pair curr = qq.poll();
            int r = curr.row;
            int c = curr.col;
            int t = curr.time;
            ans = Math.max(ans, t);

            //check in all four directions
            for(int i=0; i<4; i++) {
                int p = r + drow[i];
                int q = c + dcol[i];
                // new bounds should be with in range and these
                //cells should not be visited and oranges should be fresh on these cells
                if(p >=0 && p < m && q >= 0 && q < n) {
                    if(vis[p][q] != 2 && grid[p][q] == 1) {
                        qq.add(new Pair(p, q, t+1));
                        vis[p][q] = 2;
                    }
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++) {
                if(vis[i][j] == 1)
                    return -1;
            }
        }
        return ans;
    }
}