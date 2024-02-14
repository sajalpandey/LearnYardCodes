class Solution {
    public static void reverseArray(int [] nums, int i, int j) {
        while(i < j) {
            int temp = nums[j];
            nums[j--] = nums[i];
            nums[i++] = temp;
        }
    }
    public void rotate(int[] nums, int k) {
        k = k%nums.length;
        reverseArray(nums,0,nums.length-1);
        reverseArray(nums,0,k-1);
        reverseArray(nums,k,nums.length-1);
    }
}