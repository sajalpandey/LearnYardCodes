class Solution {
    public double findMaxAverage(int[] nums, int k) {
        int mx_sum = 0;
        int sum = 0;
        for(int i=0; i<k; i++)
            sum += nums[i];
        mx_sum = sum;
        int i=0,j=k;
        while(j < nums.length) {
            sum -= nums[i++];
            sum += nums[j++];
            if(mx_sum < sum)
                mx_sum = sum ;
        }
        return (double)mx_sum/k;
    }
}