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

        for(int i=0; i<row; ++i){
            if(matrix[i][col-1] >= target) {
                return binarySearch(matrix[i],0,col-1,target);
            }
        }
        return false;
    }
}