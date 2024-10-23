class Solution {
    public int findMin(int[] nums) {
        /**
        [4,5,6,7,0,1,2]
        [6,7,0,1,2,4,5]
         */
        int n = nums.length;
        if(n == 1)
            return nums[0];
        if(n == 2) 
            return Math.min(nums[0], nums[1]);
        
        // we have sorted array , but not rotated
        if(nums[0] < nums[n-1])
            return nums[0];
        
        int low = 0, high = n-1;
        while(low <= high) {
            int mid = (low + high) / 2;
            if(mid == n-1 || (nums[mid] < nums[mid+1]  && nums[mid] < nums[mid-1]))
                return nums[mid];
            
            if(nums[mid] < nums[high])
                high = mid - 1;
            else
                low = mid + 1;
        }
        return -1;
        
    }
}