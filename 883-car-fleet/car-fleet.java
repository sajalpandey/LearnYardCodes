class Solution {
    public int carFleet(int target, int[] position, int[] speed) {
        int ans = 0;
        int n = speed.length;
        /** First we are finding arrivalTime for each car from different positions
         */
        double[] arrivalTime = new double[target];
        for(int i=0; i<n; i++) {
            double time = ((double)(target - position[i]) / speed[i]);
            System.out.println(time);
            arrivalTime[position[i]] =  time;
        }

        double prev = 0.0;

        /** Now starting from closest car to the target , we any previous car(farthest)
        have a arrival time of < curr car time those would be part of same car fleet
        other wise new car fleet will be formed */

        for(int i=target-1; i>=0; i--) {

            double curr = arrivalTime[i];

            if(curr > prev) {
                prev = curr;
                ans++;
            }
        }

        return ans;
    }
}