
class Solution {
    public int[][] modifiedMatrix(int[][] matrix) {
        int [][] result = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                result[i][j] = matrix[i][j];
            }
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int [] col_mx = new int[n];
        for(int i=0; i<n; i++) {
            int mx = matrix[0][i];
            int index = -1;
            for(int j=0; j<m; j++) {
                if(matrix[j][i] > mx) {
                    mx = matrix[j][i];
                }
            }
            col_mx[i] = mx;
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if(result[i][j]==-1)
                    result[i][j] = col_mx[j];
            }
        }

        return result;
    }
}