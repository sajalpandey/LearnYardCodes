class Solution {
    public void setZeroes(int[][] matrix) {
        int r = matrix.length;
        int c = matrix[0].length;
        int row[] = new int[r];
        int col[] = new int[c];
        
        for(int i=0; i<r; i++){
            for(int j=0; j<c; j++) {
                if(matrix[i][j]==0) {
                    row[i] = 1;
                    col[j] = 1;
                }
            }
        }
        
        for(int i=0; i<r; i++){
            if(row[i]==1){
                for(int j=0; j<c; j++)
                    matrix[i][j] = 0;
            }
        }
        
        for(int j=0; j<c; j++){
            if(col[j]==1){
                for(int i=0; i<r; i++)
                    matrix[i][j] = 0;
            }
        }
        
    }
}