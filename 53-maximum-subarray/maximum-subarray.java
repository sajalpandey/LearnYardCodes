class Solution {
    public int maxSubArray(int[] nums) {
        /**
        Sol - 1
        Will generate all subarray and find its sum
        TC : O(n^3)
        */

        //Sol - 2
        int n = nums.length;
        int sum = nums[0];
        int max_sum = sum;

        for(int i=1; i<n; i++) {

            sum = Math.max(nums[i] + sum, nums[i]);
            max_sum = Math.max(sum, max_sum);
        }

        return max_sum;
    }
}