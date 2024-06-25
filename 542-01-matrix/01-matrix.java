class Node {
    int x;
    int y;
    int step;
    Node(int x, int y, int s) {
        this.x = x;
        this.y = y;
        this.step = s;
    }
}
class Solution {
    public int[][] updateMatrix(int[][] mat) {
        //Idea is ti find distance of nearest 0 from each 0
        //using BFS
        int m = mat.length;
        int n = mat[0].length;
        Queue<Node> q = new LinkedList<>();
        int[][] d = new int[m][n];
        boolean[][] vis = new boolean[m][n];
        for(boolean[] row : vis)
            Arrays.fill(row, false);
        //For each node with value "0" the dist to nearest 0 to be zero 
        for(int i=0; i<m; i++)
            for(int j=0; j<n; j++)
                if(mat[i][j] == 0) {
                    q.add(new Node(i, j, 0));
                    vis[i][j] = true;
                    d[i][j] = 0;
                }
        while(!q.isEmpty()) {
            Node temp = q.poll();
            int x = temp.x;
            int y = temp.y;
            int steps = temp.step;
            d[x][y] = steps;
            //check for each 4 neighbour 
            //up
            if((x-1) >=0 && vis[x-1][y] == false) {
                vis[x-1][y] = true;
                q.add(new Node(x-1, y, steps+1));
            }

            //down
            if((x+1) < m && vis[x+1][y] == false) {
                vis[x+1][y] = true;
                q.add(new Node(x+1, y, steps+1));
            }

            //left
            if((y-1) >= 0 && vis[x][y-1] == false) {
                vis[x][y-1] = true;
                q.add(new Node(x, y-1, steps+1));
            }

            //right
            if((y+1) < n && vis[x][y+1] == false) {
                vis[x][y+1] = true;
                q.add(new Node(x, y+1, steps+1));
            }
        }
        return d;
    }
}