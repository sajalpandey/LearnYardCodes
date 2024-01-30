class Solution {
    public void rotate(int[][] matrix) {

        //inplace transpose
        for(int i=0; i<matrix.length; i++) {
            for(int j=i+1; j<matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] =  temp; 
            }
        }

        //inplace reverse rows

        for(int i=0; i<matrix.length; i++) {
            int left = 0, right = matrix[0].length-1;
            while(left <= right) {
                int temp = matrix[i][right];
                matrix[i][right] = matrix[i][left];
                matrix[i][left] =  temp;
                left++;
                right--;
            }
        }
    }
}