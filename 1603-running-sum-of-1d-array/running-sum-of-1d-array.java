class Solution {
    public int[] runningSum(int[] nums) {
        //int result [] = new int[nums.length];
        int sum = 0;
        for(int i=1; i<nums.length; i++) {
            nums[i] += nums[i-1];
            //sum += nums[i];
            //nums[i] = sum;
        }
        return nums;
    }
}