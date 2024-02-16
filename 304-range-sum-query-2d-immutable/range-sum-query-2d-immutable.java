class NumMatrix {

    int prefix[][];
    int arr[][];
    public NumMatrix(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        arr = new int[r][c];
        prefix = new int[r+1][c+1];
        for (int i = 0; i < r; i++) {
            for (int j = 0; j < c; j++) {
                // if(i==0 && j==0)
                //     prefix[i+1][j+1] = matrix[i][j];
                // else if(i==0) 
                //     prefix[i+1][j+1] = matrix[i][j] + prefix[i+1][j];
                // else if(j==0)
                //     prefix[i+1][j+1] = matrix[i][j] + prefix[i][j+1];
                // else
                    prefix[i+1][j+1] = matrix[i][j] - prefix[i][j] + prefix[i][j+1] + prefix[i+1][j];
            }  
        }

    }
    
    public int sumRegion(int row1, int col1, int row2, int col2) {
        return (prefix[row2+1][col2+1] - prefix[row1][col2+1] - prefix[row2+1][col1] + prefix[row1][col1]);
    }
}

/**
 * Your NumMatrix object will be instantiated and called as such:
 * NumMatrix obj = new NumMatrix(matrix);
 * int param_1 = obj.sumRegion(row1,col1,row2,col2);
 */