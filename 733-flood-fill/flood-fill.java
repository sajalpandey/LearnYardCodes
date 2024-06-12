class Solution {
    int[][] visited;
    public void dfs(int i, int j, int m, int n, int[][] image, int color) {
        if(i<0 || j<0 ||  i>=m || j>=n || visited[i][j]==color)
            return;

        visited[i][j] = color;
        //fill in all 4 directions
        if(i-1 >= 0 && image[i][j] == image[i-1][j])
            dfs(i-1, j, m, n, image, color);
        if(i+1 < m && image[i][j] == image[i+1][j])
            dfs(i+1, j, m, n, image, color);
        if(j-1 >= 0 && image[i][j] == image[i][j-1])
            dfs(i, j-1, m, n, image, color);
        if(j+1 < n && image[i][j] == image[i][j+1])
            dfs(i, j+1, m, n, image, color);   
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        int m = image.length;
        int n = image[0].length;
        visited = new int[m][n];
        for(int i=0; i<m ;i++) {
            for(int j=0; j<n; j++) {
                visited[i][j] = image[i][j];
            }
        }
        // if(image[sr][sc] == 0)
        //     return visited;
        dfs(sr, sc, m, n, image, color);
        return visited;
    }
}