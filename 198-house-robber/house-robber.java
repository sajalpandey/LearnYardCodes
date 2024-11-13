class Solution {
    public int rob(int[] nums) {
        //space optimized bottom up
        int n = nums.length;
        if(n == 1)
            return nums[0];
        int prev1 = nums[0], prev2 = 0, curr = 0;

        for(int i=1; i<n; i++) {
            int takeit = nums[i];
            if(i > 1)
                takeit += prev2;
            int skipit = prev1;

            curr = Math.max(takeit, skipit);
            prev2 = prev1;
            prev1 = curr;
        }
        return curr;
        
    }
}