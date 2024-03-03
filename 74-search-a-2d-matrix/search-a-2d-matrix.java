class Solution {
    public boolean binarySearch(int [] arr, int l, int h, int target) {
        while(l <= h) {
            int mid = (l + h) / 2;
            System.out.println("arr[mid] = "+arr[mid]);
            if(arr[mid] == target)
                return true;
            if(arr[mid] < target)
                l = mid + 1;
            else
                h = mid -1;
        }
        return false;
    }
    public boolean searchMatrix(int[][] matrix, int target) {
        int row = matrix.length;
        int col = matrix[0].length;
        int lo = 0,hi = row -1;
        int row_num = -1;
        while(lo <= hi) {
            int mid = (lo + hi)/ 2;
            if(matrix[mid][col-1] >= target) {
                row_num = mid;
                hi = mid -1;
            } else {
                lo = mid + 1;
            }
        }
        if(row_num!=-1)
            return binarySearch(matrix[row_num],0,col-1,target);
        return false;
    }
}