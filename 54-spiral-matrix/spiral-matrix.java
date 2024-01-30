class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();
        int row = matrix.length;
        int col = matrix[0].length;
        int top = 0, right = col-1, bottom = row - 1, left = 0;

        while(left<=right && top<=bottom) {
            //print top row
            for(int i=left; i<=right; i++)
                result.add(matrix[top][i]);
            top++;
            //print right most column
            for(int i=top; i<=bottom; i++)
                result.add(matrix[i][right]);
            right--;

            //to print a valid bottom row
            if(top <= bottom) {
                //print bottom row
                for(int i=right; i>=left; i--)
                    result.add(matrix[bottom][i]);
                bottom--;
            }
            if(left<=right) {
                //print left most column
                for(int i=bottom; i>=top; i--)
                    result.add(matrix[i][left]);
                left++;
            }
        }
        
        
        return result;
    }
}