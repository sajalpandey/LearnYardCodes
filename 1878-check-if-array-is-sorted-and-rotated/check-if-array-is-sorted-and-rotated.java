class Solution {
    public boolean check(int[] nums) {
        int n = nums.length;
        int trough=0;
        for(int i=0; i<n-1 ;i++) {
            if(nums[i+1] < nums[i])
                trough++;
        }
        //Array is sorted and not rotated 
        if(trough==0)
            return true;
        if(trough==1 && nums[0] >= nums[n-1])
            return true;
        return false;
    }
}