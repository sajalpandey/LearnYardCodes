class Solution {
    public long[] findPrefixScore(int[] nums) {
        long [] result = new long[nums.length];
        long mx_ele = 0,score = 0,conver = 0;
        for(int i=0; i<nums.length; i++) {
            mx_ele = Math.max(mx_ele, nums[i]);
            conver = nums[i] + mx_ele;
            score += conver;
            result[i] = score;
        }
        return result;
    }
}