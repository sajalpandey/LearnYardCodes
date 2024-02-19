class Solution {
    public int smallestRangeI(int[] nums, int k) {
        int mn = nums[0], mx = nums[0];

        for(int i=0; i<nums.length; i++) {
            mn = Math.min(mn, nums[i]);
            mx = Math.max(mx, nums[i]);
        }

        int result = mx - k - (mn + k);
        return result < 0 ? 0 : result;
    }
}