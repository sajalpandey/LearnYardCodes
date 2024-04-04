class Solution {
    public int[][] matrixReshape(int[][] mat, int r, int c) {
        int row = mat.length, col = mat[0].length;
        int totalEle = row * col;
        if(totalEle != r * c)
            return mat;
        int [][] result = new int[r][c];
        for(int i=0; i<totalEle; i++) {
            result[i/c][i%c] = mat[i/col][i%col];
        }
        return result;
    }
}