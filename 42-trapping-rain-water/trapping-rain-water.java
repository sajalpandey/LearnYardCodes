class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int i = 0, j = n-1,lmax = 0, rmax = 0;
        while(i <= j) {
            if(height[i] <= height[j]) {
                // fill from left side;
                lmax = Math.max(lmax, height[i]);
                result += lmax - height[i];
                i++;
            } else {
                rmax = Math.max(rmax, height[j]);
                result += rmax - height[j];
                j--;
            }
        }
        return result;
    }
}