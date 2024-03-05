class Solution {
    public int searchInsert(int[] nums, int target) {
        int n = nums.length;
        int ans = n;
        int lo = 0, hi = n - 1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] >= target) {
                ans = mid;
                hi = mid - 1;
            } else
                lo = mid + 1;
        }
        return ans;
    }
}