class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int i = 0, j = 0;
        int result = Integer.MAX_VALUE, sum = 0;
        while(j < nums.length) {
            if(sum < target) {
                sum += nums[j++];
            } else {
                while(sum >= target && i < j) {
                    result = Math.min(result, (j - i));
                    sum -= nums[i++];
                }
                sum += nums[j++];
            }
        }
        while(sum >= target && i < j) {
            result = Math.min(result, (j - i));
            sum -= nums[i++];
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }
}