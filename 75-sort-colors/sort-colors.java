class Solution {
    public void swap(int[] nums, int l, int r){
        int temp = nums[r];
        nums[r] = nums[l];
        nums[l] = temp;
    }
    public void sortColors(int[] nums) {
        int i = 0, j = nums.length - 1, k = 0;
        while(k < nums.length) {
            if(nums[k] == 0 && k > i) {
                swap(nums, i, k);
                i++;
                
            } else if(nums[k] == 2 && k < j) {
                swap(nums, j, k);
                j--;
                
            } else {
                k++;
            }
        }
    }
}