class Solution {
    public int binarySearch_1(int [] arr, int lo, int hi, int x) {
        int ans = -1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] > x)
                hi = mid - 1;
            else if(arr[mid] < x)
                lo = mid + 1;
            else {
                ans = mid;
                hi = mid - 1;
            }
        }
        return ans;
    }
    public int binarySearch_2(int [] arr, int lo, int hi, int x) {
        int ans = -1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(arr[mid] > x)
                hi = mid - 1;
            else if(arr[mid] < x)
                lo = mid + 1;
            else {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }
    public int[] searchRange(int[] arr, int x) {
        int n = arr.length;
        int firstOcc = binarySearch_1(arr,0,n-1,x);
        int lastOcc = binarySearch_2(arr,0,n-1,x);
        int [] result = new int[2];
        result[0] = firstOcc;
        result[1] = lastOcc;
        return result;
    }
}