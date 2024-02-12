class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int mx_sum = sum;
        for(int i=1; i<nums.length; i++) {
            sum = Math.max(sum+nums[i] , nums[i]);
            mx_sum = Math.max(mx_sum, sum);
        }
        return mx_sum;
    }
}