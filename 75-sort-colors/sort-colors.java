class Solution {
    public void swap(int[] nums, int i, int k) {
        int temp = nums[k];
        nums[k] = nums[i];
        nums[i] = temp;
    }
    public void sortColors(int[] nums) {
        int i=0, j=nums.length-1;
        for(int k=0; k<nums.length; k++) {
            //
            if(nums[k] == 0 && k > i) {
                swap(nums, i, k);
                k--;
                i++;
            } else if(nums[k] == 2 && k < j) {
                swap(nums, k, j);
                k--;
                j--;
            } 
                
        }
    }
}