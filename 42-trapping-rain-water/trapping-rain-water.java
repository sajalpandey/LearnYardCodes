class Solution {
    public int trap(int[] height) {
        /**
        We will try to find for each tower how much water it can contribute to the
        total trap 
        water contributed = Min(left max - rightMax) - tower height (for each tower)
         */

        //2 pass solution TC: O(2*n)
        int n = height.length; 
        // int[] leftMax = new int[n];
        // int[] rightMax = new int[n];
        // leftMax[0] = height[0];
        // for(int i=1; i<n; i++)
        //     leftMax[i] = Math.max(leftMax[i-1], height[i]);
        // rightMax[n-1] = height[n-1];
        // for(int i=n-2; i>=0; i--)
        //     rightMax[i] = Math.max(rightMax[i+1], height[i]);
        
        // int totalWater = 0;
        // for(int i=0; i<n; i++)
        //     totalWater += Math.min(leftMax[i], rightMax[i]) -  height[i];

        // return totalWater;

        //1 Pass solution TC: O(n)
        /**
        for each ele min of leftMax & rightMax is contributing to the solution
        so take 2 varibales left & right
         */

        int i = 0, j = n-1, lmax = 0, rmax = 0;
        int ans = 0;
        while(i <= j){
            if(height[i] < height[j]) {
                lmax = Math.max(lmax, height[i]);
                ans += lmax - height[i];
                i++;
            } else {
                rmax = Math.max(rmax, height[j]);
                ans += rmax - height[j];
                j--;
            }
        }
        return ans;
    }
}