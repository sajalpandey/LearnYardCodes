class Solution {
    public int[] sortedSquares(int[] nums) {
        int [] result = new int[nums.length];

        int i=0 ,j=nums.length-1,p=nums.length-1;
        while(i<=j) {
            if(Math.abs(nums[i]) > Math.abs(nums[j])){
                result[p--] = nums[i]*nums[i];
                i++;
            }
            else {
                result[p--] = nums[j]*nums[j];
                j--;
            }
        }
        return result;
    }
}