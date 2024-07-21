class Solution {
    public void setZeroes(int[][] matrix) {
        boolean isFirstRowZero = false, isFirstColZero = false;
        for(int i=0; i<matrix.length; i++) {
            if(matrix[i][0] == 0)
                isFirstColZero = true;
        }

        for(int i=0; i<matrix[0].length; i++) {
            if(matrix[0][i] == 0)
                isFirstRowZero = true;
        }
        //one pass to mark first row and col as '0' if row & col contains any zero
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][j] == 0) {
                    matrix[0][j] = 0;
                    matrix[i][0] = 0;
                }
            }
        }

        //now make them zero
        for(int i=1; i<matrix.length; i++) {
            for(int j=1; j<matrix[i].length; j++) {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
        }

        //mark first row & col as zero
        if(isFirstColZero == true) {
            for(int i=0; i<matrix.length; i++) {
                matrix[i][0] = 0;
            }
        }

        if(isFirstRowZero == true) {
            for(int i=0; i<matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
    }
}