class Solution {
    public int shortestPathBinaryMatrix(int[][] grid) {
        

        int[][] directions = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}, {-1, -1}, {-1, 1}, {1, -1}, {1, 1}};
        Queue<int[]> q = new LinkedList<>();
        q.add(new int[]{0,0, 1});

        int m = grid.length, n = grid[0].length;
        if (grid[0][0] == 1 || grid[n - 1][n - 1] == 1) 
            return -1;
        int[][] dist = new int[m][n];
        for(int[] row : dist)
            Arrays.fill(row, (int)1e9);
        dist[0][0] = 1;
        while(!q.isEmpty()) {
            int[] tuple = q.poll();
            int steps = tuple[2];
            int x = tuple[0];
            int y = tuple[1];
            if(x == m-1 && y == n-1)
                return steps;
            for(int i=0; i<8; i++) {
                int p = directions[i][0];
                int qq = directions[i][1];
                int newX = x + p;
                int newY = y + qq;

                if(newX<0 || newX>=m || newY<0 || newY>=n || grid[newX][newY] == 1)
                    continue;
                if(steps+1 < dist[newX][newY]) {
                    dist[newX][newY] = steps+1;
                    q.add(new int[]{newX, newY, steps+1});

                }
            }
        }
        return -1;
    }
}