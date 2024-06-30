class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length;
        int odd = -1, even = -1, alternate = 0;
        int sign = -1;
        for (int i = 0; i < n; i++) {
            if(nums[i]%2 != 0) {
                if(odd == -1)
                    odd = 0;
                odd++;
                if(sign != 1) {
                    alternate++;
                    sign = 1;
                }
            } else {
                if(even == -1)
                    even = 0;
                even++;
                if(sign != 0) {
                    alternate++;
                    sign = 0;
                }
            }
        }
        return Math.max(alternate, Math.max(even, odd));
    }
}