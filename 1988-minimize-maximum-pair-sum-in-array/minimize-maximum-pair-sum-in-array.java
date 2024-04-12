class Solution {
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = -1;
        for(int i=0; i<n/2; ++i)
            result = Math.max(result, (nums[i] + nums[n-i-1]));
        return result;
    }
}