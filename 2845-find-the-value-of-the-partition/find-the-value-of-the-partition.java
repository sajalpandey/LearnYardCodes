class Solution {
    public int findValueOfPartition(int[] nums) {
        int n =  nums.length;
        Arrays.sort(nums);
        int result = Integer.MAX_VALUE;
        for(int i=1; i<n; ++i) {
            result = Math.min(result,(nums[i]-nums[i-1]));
        }
        return result;
    }
}