class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int i=0, j=0, sum = 0;
        double avg = Integer.MIN_VALUE * 1.0;
        while(j < nums.length) {
            if(j >= k-1) {
                sum += nums[j];
                if((j-k) >= 0)
                    sum -= nums[j-k];
                avg = Math.max(avg , (1.0 * sum/k*1.0));
            } else {
                sum += nums[j];
            }
            j++;
        }
        return avg;
    }
}