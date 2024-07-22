class Solution {
    public int maxProduct(int[] nums) {
        double result = Integer.MIN_VALUE, prefix = 1, suffix = 1;
        int n = nums.length;
        for(int i=0; i<n; i++) {
            prefix *= nums[i];
            suffix *= nums[n-1-i];
            result = Math.max(result, Math.max(prefix, suffix));
            if(prefix == 0)
                prefix = 1;
            if(suffix == 0)
                suffix = 1;
        }
        return (int)result;
    }
}