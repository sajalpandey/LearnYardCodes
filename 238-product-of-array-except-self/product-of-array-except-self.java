class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] suffix = new int[n];
        suffix[n-1] = 1;
        for(int i=n-2; i>=0; i--) {
            suffix[i] = nums[i+1] * suffix[i+1];
        }
        int mul = 1;
        int[] result = new int[n];
        for(int i=0; i<n; i++) {
            result[i] = mul * suffix[i];
            mul *= nums[i];
        }
        return result;
    }
}