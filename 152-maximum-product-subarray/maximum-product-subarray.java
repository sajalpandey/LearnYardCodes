class Solution {
    public int maxProduct(int[] nums) {
        /**
        If array contains all positive, then all ele mul will be ans
        if array contains even neg , then all ele mul will be ans
        if arrya contains odd neg ele
        then left mul of each neg ele & right mul of each neg ele and max out of it wiil
        be our ans

         */
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