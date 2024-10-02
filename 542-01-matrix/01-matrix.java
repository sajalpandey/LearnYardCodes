class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Idea is to find distance of nearest 0 from each 0
        //using BFS
        int m = mat.length;
        int n = mat[0].length;
        Queue<int[]> q = new LinkedList<>();
        int[][] d = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for(boolean[] row : vis)
            Arrays.fill(row, false);
        //For each node with value "0" the dist to nearest 0 to be zero 
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) {
                if(mat[i][j] == 0) {
                    q.add(new int[] {i, j, 0});
                    vis[i][j] = true;
                    d[i][j] = 0;
                }
            }
        }
        int[] drow = {-1,1,0,0};
        int[] dcol = {0,0,-1,1};

        while(!q.isEmpty()) {
            int[] row = q.poll();
            int p = row[0];
            int s = row[1];
            int dist = row[2];

            //mark all 4 directions
            for(int i=0; i<4; i++) {
                int newR = p + drow[i];
                int newC = s + dcol[i];
                if(newR<0 || newR>m-1 || newC<0 || newC>n-1 || vis[newR][newC] == true)
                    continue;
                vis[newR][newC] = true;
                d[newR][newC] = 1 + d[p][s];
                q.add(new int[] {newR, newC, d[newR][newC]});
            }
        }
        return d;
    }
}