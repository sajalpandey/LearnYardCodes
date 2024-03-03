class Solution {
    public int search(int[] nums, int target) {
        int lo = 0, hi = nums.length-1;
        while(lo <= hi) {
            int mid = (lo + hi) / 2;
            if(nums[mid] == target) 
                return mid;
            else if(nums[lo] <= nums[mid]) {
                //we are in sorted half and based on some checks
                // for target we can say target dosnt lie in this half
                if(target < nums[mid] && target >= nums [lo])
                    hi = mid - 1;
                else
                    lo = mid + 1;
            } else {
                // this half is sorted
                if(target > nums[mid] && target <= nums[hi])
                    lo = mid + 1;
                else
                    hi = mid - 1;
            }
        }
        return -1;
    }
}