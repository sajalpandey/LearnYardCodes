class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        int lastjumpindex = 0, maxjump = 0;
        int result = 0;
        if(n==1)
            return 0;
        for(int i=0; i<n; i++) {
            // This is the max we can reach
            maxjump = Math.max(maxjump, i+nums[i]);

            // This means we have traversed one window
            if(i==lastjumpindex) {
                lastjumpindex = maxjump;
                result++;
                if(maxjump >= n-1)
                    return result;
            }

            
        }
        return result;
    }
}