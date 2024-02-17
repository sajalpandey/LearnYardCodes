class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long prefix[] = new long[n];
        long sum = 0;
        for(int i=0; i<n; i++) {
            sum += nums[i];
            prefix[i] = sum;
        }
        long result=-1, min = Integer.MAX_VALUE;
        for(int i=0; i<n; i++) {
            long a1 = prefix[i] / (i+1);
            long a2 = (i==n-1) ? 0 : (prefix[n-1] - prefix[i]) / (n-i-1);
            long avg = Math.abs(a1 - a2);
            if(min > avg) {
                result = i;
                min = avg;
            }
        }
        return (int)result;
    }
}