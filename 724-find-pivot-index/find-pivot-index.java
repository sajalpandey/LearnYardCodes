class Solution {
    public int pivotIndex(int[] nums) {
        int result = -1,left_sum=0,total_sum=0;
        for(int ele : nums) {
            total_sum += ele;
        }
        for(int i=0; i<nums.length; i++) {
            if(2*left_sum == total_sum - nums[i]) {
                result = i;
                break;
            }
            left_sum += nums[i];
        }
        return result;
    }
}