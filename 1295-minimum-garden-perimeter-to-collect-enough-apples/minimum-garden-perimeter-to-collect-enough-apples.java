class Solution {
    public long minimumPerimeter(long neededApples) {
        // To calculate tn = 12 * i * i;
        //in binary search = ( 2 * (n * (n+1) * (2n + 1)))
        long lo = 1, hi = (long)1e5; 
        long result = 0;
        while(lo <= hi) {
            long mid = ((hi + lo) / 2);
            long apples = (2 * mid * (mid + 1) * (2*mid+1));
            if(apples >= neededApples) {
                result = mid;
                hi = mid -1;
            } else
                lo = mid + 1;
        }
        return (8*result);
    }
}