class Solution {
    public int[] rearrangeArray(int[] nums) {
        int [] result = new int[nums.length];
        int i=0,j=1;
        for(int x=0; x<nums.length; x++) {
            if (nums[x]>0) {
                result[i] = nums[x];
                i += 2;
            }
            else {
                result[j] = nums[x];
                j += 2;
            }
        }
        return result;
    }
}