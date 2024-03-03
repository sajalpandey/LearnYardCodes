class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0,hi = row*col -1;

        while(lo <= hi) {
            int mid = (lo + hi)/ 2;
            int value = matrix[mid/col][mid%col];
            if(value == target)
                return true;
            if(target < value)
                hi = mid - 1;
            else
                lo = mid + 1;
        }
        return false;
    }
    /**
    int mid_value = matrix[mid/col_num][mid%col_num];
    row = 3, col = 4
    l=0,h=11 == row*col-1
    mid = 5
    mid_value = matrix[5/4][5%4] == matrix[1][1]
     0,1,2,3,--4, 5, 6, 7, --8, 9, 10,11
    [1,3,5,7,--10,11,16,20,--23,30,34,60]
     */
}