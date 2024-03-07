class Solution {
    public long binaryTrips(int[] time, long minTime) {
        long result = 0;
        for(int i=0; i<time.length; ++i)
            result += minTime/time[i];
        return result;
    }
    public long minimumTime(int[] time, int totalTrips) {
        if(time.length==1) {
            return (long)time[0]*totalTrips;
        }
        long lo = 1, hi = Integer.MIN_VALUE;
        for(int ele : time) {
            lo = Math.min(ele, lo);
            hi = Math.max(ele, hi);
        }
        hi = (long)hi * totalTrips;
        long result = 1;
        while(lo <= hi) {
            long mid = (lo + (hi - lo) / 2);
            long trips = binaryTrips(time,mid);

            if(trips < totalTrips)
                lo = mid + 1;
            else {
                result = mid;
                hi = mid - 1;
            }
        }
        return result;
    }
}