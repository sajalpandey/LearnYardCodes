class Solution {
    public boolean helper(int[] ranks, long mid, long cars) {
        long noOfCars = 0;
        for(int ele : ranks) {
            noOfCars += (int)Math.sqrt(mid / ele);
        }
        //System.out.println("mid = "+mid+" -- noOfCars = "+noOfCars);
        return (noOfCars >= cars) ? true : false;
    }
    public long repairCars(int[] ranks, int cars) {
        long lo = 1, hi = Integer.MIN_VALUE;
        for(int ele : ranks) {
            lo = Math.min(lo, ele);
            hi = Math.max(hi, ele);
        }
        hi = hi * cars * cars;
        //System.out.println("lo = "+lo+" -- hi = "+hi);
        long ans = 1;
        while(lo <=  hi) {
            long mid = lo + (hi - lo) / 2;
            boolean repairedCars = helper(ranks, mid, cars);
            if(repairedCars) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}