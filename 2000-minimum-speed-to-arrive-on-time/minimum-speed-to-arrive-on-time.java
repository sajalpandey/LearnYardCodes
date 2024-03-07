class Solution {
    public double minSpeed(int[] dist, int mid) {
        double hour = 0.0;
        for(int i=0; i<dist.length; ++i) {
            if(i!=dist.length-1)
                hour += Math.ceil((double) dist[i] / mid);
            else
                hour += ((double) dist[i] / mid);
            //System.out.println("mid = "+mid+ "-- hour = "+hour);
        }
        //System.out.println("hour = "+hour);
        return hour;
    }
    public int minSpeedOnTime(int[] dist, double hour) {
        int lo = 1, hi = 10000000;
        int result = -1;
        // for(int ele : dist)
        //     hi = Math.max(ele, hi);
        //System.out.println("lo = "+lo+" --high = "+hi);
        while(lo <= hi) {
            int mid = (lo + hi)/2;
            //System.out.println("mid = "+mid);
            double reqHours = minSpeed(dist, mid);
            if(reqHours <= hour){
                result = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return result;
    }
}