class Solution {
    public int binarySearch(int[] nums, int low, int high, int target) {
        if(low >  high)
            return -1;
        int mid = (low + high) / 2;
        if(nums[mid] == target)
            return mid;
        if(target <  nums[mid])
            return binarySearch(nums,0,mid-1,target);
        else
            return binarySearch(nums,mid+1,high,target);
    }
    public int search(int[] nums, int target) {
        return binarySearch(nums,0,nums.length-1,target);
    }
}