class Solution {
    public int minDifference(int[] nums) {
        int n = nums.length;
        if(n < 5)
            return 0;
        Arrays.sort(nums);

        int start = 0, end = n - 1;
        return Math.min((nums[n-1] - nums[start+3]), Math.min(nums[n-2]-nums[start+2], Math.min(nums[n-3]-nums[start+1], nums[n-4]-nums[start])));
    }
}