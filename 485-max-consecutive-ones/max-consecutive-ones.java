class Solution {
    public int findMaxConsecutiveOnes(int[] nums) {
        int i = -1, j = 0;
        int ans = 0;
        while(j < nums.length) {
            while(j < nums.length && nums[j] == 1) {
                if(i == -1)
                    i = j;
                j++;
                ans = Math.max(ans, (j - i));
            }
            if(j < nums.length && nums[j] == 0) {
                i = -1;
                j++;
            }
        }
        return ans;
    }
}