class Solution {
    public int longestOnes(int[] nums, int k) {
        int i=0,j=0;
        int mx_len = 0,len=0;
        int p = k;
        while(j<nums.length) {
            if(nums[j]==1) {
                len++;
                j++;
                mx_len = Math.max(mx_len, len);
            } else {
                if(p==0) {
                    if(nums[i]==0) 
                        p++;
                    i++;
                    len--;
                } else {
                    p--;
                    j++;
                    len++;
                    mx_len = Math.max(mx_len, len);
                }
                
            }
        }
        return mx_len;
    }
}