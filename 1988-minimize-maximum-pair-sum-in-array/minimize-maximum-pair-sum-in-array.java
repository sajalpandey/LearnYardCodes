class Solution {
    /**
    [3,5,4,2,4,6]
    [2,3,4,4,5,6]
    [2,3,3,5]
    [7,6]
     */
    public int minPairSum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        int result = -1;
        for(int i=0; i<n/2; i++)
            result = Math.max(result, (nums[i] + nums[n-i-1]));
        return result;
    }
}