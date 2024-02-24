class Solution {
    public boolean canJump(int[] nums) {
        int lastjumpidx = 0, maxjump = 0;
        if(nums.length==1)
            return true;
        int result = 0;
        for(int i=0; i<nums.length; i++) {
            maxjump = Math.max(maxjump, i+nums[i]);
            if(i==lastjumpidx) {
                result++;
                lastjumpidx = maxjump;
                if(maxjump >= nums.length-1)
                    return true;
            }
        }

        return false;
    }
}