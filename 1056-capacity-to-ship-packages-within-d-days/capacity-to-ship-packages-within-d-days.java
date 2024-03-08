class Solution {
    public boolean canBeShipped(int[] weights, int mid, int days){
        int d = 1,w = 0;
        for(int ele : weights){
            if((w + ele) <= mid) {
                w += ele;
            } else {
                d++;
                w = 0;
                w += ele;
            }
        }
        return (d <= days ? true : false);
    }
    public int shipWithinDays(int[] weights, int days) {
        int ans = 1;
        int lo = 1, hi = 0;
        for(int ele : weights) {
            hi += ele;
            lo = Math.max(lo, ele);
        }
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(canBeShipped(weights,mid, days)) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}