class Solution {
    public List<Integer> luckyNumbers (int[][] matrix) {
        int row = matrix.length;
        int col = matrix[0].length;
        HashSet<Integer> rowMinArr = new HashSet<>();
        List<Integer> colMaxArr = new ArrayList<>();
        List<Integer> result = new ArrayList<>();
        for(int i=0; i<row; i++) {
            int mn = matrix[i][0];
            for(int j=0; j<col; j++) {
                mn = Math.min(mn , matrix[i][j]);
            }
            rowMinArr.add(mn);
        }

        for(int i=0; i<col; i++) {
            int mx = matrix[0][i];
            for(int j=0; j<row; j++) {
                mx = Math.max(mx , matrix[j][i]);
            }
            if(rowMinArr.contains(mx))
                result.add(mx);
        }
        return result;
    }
}