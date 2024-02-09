class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int mx_count=0;
        int count=0;
        for(int i=0; i<nums.length; i++) {
            if(nums[i]==1) {
                mx_count = Math.max(mx_count,++count);
            } else {
                count = 0;
            }
        }
        mx_count = Math.max(mx_count,count);
        return mx_count;
    }
}