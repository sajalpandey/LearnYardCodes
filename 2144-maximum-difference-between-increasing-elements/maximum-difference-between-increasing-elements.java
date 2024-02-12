class Solution {
    public int maximumDifference(int[] nums) {
        int mx_so_far = -1;
        int i=0,j=1;
        int mx = nums[0];
        while(j<nums.length) {
            if(nums[j]!=mx)
                mx_so_far = Math.max(mx_so_far,nums[j]-mx);
            mx = Math.min(mx,nums[j++]);
        }
        return mx_so_far;
    }
}