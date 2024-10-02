class Solution {
    int[][] vis;
    public void dfs(int[][] image, int i, int j, int m, int n, int newColor) {
        if(i<0 || i==m || j<0 || j==n || vis[i][j] == newColor)
            return;
        
        vis[i][j] = newColor;
        if(i-1 >= 0 && image[i][j] == image[i-1][j])
            dfs(image, i-1, j, m, n, newColor);
        if(i+1 < m && image[i][j] == image[i+1][j])
            dfs(image, i+1, j, m, n, newColor);
        if(j-1 >= 0 && image[i][j] == image[i][j-1])
            dfs(image, i, j-1, m, n, newColor);
        if(j+1 < n && image[i][j] == image[i][j+1])
            dfs(image, i, j+1, m, n, newColor);
        
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int m = image.length, n = image[0].length;
        vis = new int[m][n];
        for(int i=0; i<m; i++) {
            for(int j=0; j<n; j++) 
                vis[i][j] = image[i][j];
        }
        if(image[sr][sc] == newColor)
            return vis;
        dfs(image, sr, sc, m, n, newColor);
        return vis;
    }
}