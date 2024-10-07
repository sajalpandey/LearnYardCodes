class Solution {
    public int minimumEffortPath(int[][] heights) {
        int m = heights.length, n = heights[0].length;

        int[][] dist = new int[m][n];
        for(int[] row : dist)
            Arrays.fill(row, (int)1e9);
        PriorityQueue<int[]> q = new PriorityQueue<>((x,y) -> x[0]-y[0]);

        q.add(new int[]{0,0,0});
        dist[0][0] = 0;
        int[][] dir = {{-1,0},{0,1},{1,0},{0,-1}};

        while(!q.isEmpty()) {
            int[] tuple = q.poll();
            int d = tuple[0];
            int x = tuple[1];
            int y= tuple[2];
            if(x == m-1 && y == n-1)
                return d;
            for(int i=0; i<4; i++) {
                int newX = x + dir[i][0];
                int newY = y + dir[i][1];
                if(newX<0 || newX>=m || newY<0 || newY>=n)
                    continue;
                int minEffort = Math.max(d, Math.abs(heights[x][y] - heights[newX][newY]));

                if(dist[newX][newY] > (minEffort)) {
                    dist[newX][newY] = (minEffort) ;
                    q.add(new int[]{minEffort, newX, newY});
                }
            }
        }
        return -1;
    }
}