class Solution {
    public int singleNonDuplicate(int[] arr) {
        /*
        * [1,1,2,3,3,4,4,8,8]
        *  0,1,2,3,4,5,6,7,8
        * */
        int n = arr.length;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            int midnum = 0;
            if(mid > 0 && arr[mid]==arr[mid-1])
                midnum = 2;
            else if(mid < n-1 && arr[mid]==arr[mid+1])
                midnum = 1;
            if(midnum == 0)
                return arr[mid];
            if(midnum==2) {
                if(mid%2==0)
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                if(mid%2==0)
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}