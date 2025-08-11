class Solution {
    public int longestOnes(int[] nums, int k) {
        int maxLen = 0, i = 0, j = 0;
        for(j=0; j<nums.length; j++) {
            if(nums[j] == 0)
                k--;
            
            //exhausted max allowed zero limit , shrink window
            while(i <= j && k < 0) {
                if(nums[i] == 0)
                    k++;
                i++;
            }
            
            maxLen = Math.max(maxLen, j-i+1);
        }
        return maxLen;
    }
}