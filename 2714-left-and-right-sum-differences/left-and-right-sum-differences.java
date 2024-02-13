class Solution {
    public int[] leftRightDifference(int[] nums) {
        int right_sum[] = new int[nums.length];
        int sum = 0;
        for(int i=nums.length-1; i>=0; i--) {
            right_sum[i] = sum;
            sum += nums[i];
        }
        sum = 0;
        for(int i=0; i<nums.length; i++) {
            right_sum[i] = Math.abs(sum - right_sum[i]);
            sum += nums[i];
        }
        return right_sum;
    }
}