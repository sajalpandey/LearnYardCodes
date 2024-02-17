class Solution {
    public int minimumAverageDifference(int[] nums) {
        int n = nums.length;
        long prefix[] = new long[n];
        prefix[0] = nums[0];
        for(int i=1; i<n; i++) {
            prefix[i] = prefix[i-1] + nums[i];
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