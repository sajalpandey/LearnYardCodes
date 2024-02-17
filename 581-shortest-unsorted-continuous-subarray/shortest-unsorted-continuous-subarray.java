class Solution {
    public int findUnsortedSubarray(int[] nums) {
        int n = nums.length;
        int start = -1, end = -2;
        int mx = nums[0], mn = nums[n-1];
        for(int i=0; i<n; i++) {
            mx = Math.max(mx,nums[i]);
            if(nums[i] < mx)
                end = i;
        }

        for(int i=n-1; i>=0; i--) {
            mn = Math.min(mn,nums[i]);
            if(nums[i] > mn)
                start = i;
        }
        return (end-start+1);
    }
}