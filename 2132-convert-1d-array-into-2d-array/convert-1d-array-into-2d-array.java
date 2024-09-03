class Solution {
    public int[][] construct2DArray(int[] original, int m, int n) {
        int[][] result = new int[m][n];
        if(m*n != original.length)
            return new int[][]{};
        for(int i=0; i<original.length; i++) {
            result[i/n][i%n] = original[i];
        }
        return result;
    }
}