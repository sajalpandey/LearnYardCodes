class Solution {
    public boolean isPossible(int[] bloom, long mid, int m, int k) {
        long bouquet = 0;
        int flower = 0;
        for(int ele : bloom) {
            flower = (ele <= mid ? ++flower : 0);
            if(flower == k) {
                bouquet++;
                flower = 0;
            }
        }
        return (bouquet >= m ? true : false); 
    }
    public int minDays(int[] bloomDay, int m, int k) {
        long ans = -1;
        if(bloomDay.length < (m*k))
            return (int)ans;
        long lo = 1, hi = Integer.MIN_VALUE;
        for(int ele : bloomDay)
            hi = Math.max(hi, ele);
        while(lo <= hi) {
            long mid = (lo + (hi - lo) / 2);
            if(isPossible(bloomDay, mid, m, k)) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return (int)ans;
    }
}