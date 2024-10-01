class Solution {
    public int orangesRotting(int[][] grid) {
        int m = grid.length; int n = grid[0].length;
        int[][] vis = new int[m][n];
        int countFresh = 0;
        Queue<int[]> q = new LinkedList<>();
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                // if its rotten add it in queue
                if(grid[i][j] == 2) {
                    q.add(new int[] {i, j});
                    vis[i][j] = 2;
                } else if(grid[i][j] == 1) 
                    countFresh++;
            }
        }
        
        int ans = 0;
        int[] drow = {-1, 0, 1, 0};
        int[] dcol = {0, 1, 0, -1};
        //System.out.println("Sajal = "+countFresh);
        if(countFresh == 0)
            return 0;
        while(!q.isEmpty()) {
            int size = q.size();
            ans++;
            while(size-- > 0) {
                int[] row = q.poll();
                for(int i=0; i<4; i++) {
                    int newR = row[0] + drow[i];
                    int newC = row[1] + dcol[i];
                    //if new bounds are within 
                    if(newR >=0 && newR < m && newC >=0 && newC < n) {
                        if(vis[newR][newC]!=2 && grid[newR][newC] == 1) {
                            vis[newR][newC] = 2;
                            q.add(new int[] {newR, newC});
                            countFresh--;
                        }
                    }
                }
            }
        }
        //System.out.println("Sajal2 = "+countFresh);
        return (countFresh == 0 ? ans -1 : -1 );
    }
}