class Solution {
    public int findMin(int[] nums) {
        int n = nums.length - 1;
        int start = 0, end = nums.length - 1;
        if(nums.length==2)
            return Math.min(nums[start],nums[end]);
        if(nums.length==1)
            return nums[0];
        if(nums[0] < nums[n])
            return nums[0];
        while(start <= end) {
            int mid = (start + end) / 2;
            if(mid == n && nums[mid] < nums[mid-1]) {
                return nums[mid];
            }
            if((mid-1) >= 0 && nums[mid] < nums[mid-1] && (mid+1) <= n &&  nums[mid] < nums[mid+1]) {
                return nums[mid];
            } else if (nums[mid] < nums[end]) 
                end = mid - 1;
            else 
                start = mid + 1;
        }
        return -1;
    }
}