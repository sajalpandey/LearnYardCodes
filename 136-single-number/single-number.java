class Solution {
    public int singleNumber(int[] nums) {
        int x = 0;
        for(int ele : nums)
            x ^= ele;
        return x;
    }
}