class Solution {
    public int binarySearch(int target, int lo, int hi) {
        int ans = 0;
        while(lo <=  hi) {
            int mid = (lo + hi) / 2;
            if((mid) > target / mid)
                hi = mid - 1;
            else if((mid) <= target / mid) {
                ans = mid;
                lo = mid + 1;
            }
        }
        return ans;
    }
    public int mySqrt(int x) {
        if(x==1)
            return 1;
        return binarySearch(x,1,x/2);
    }
}