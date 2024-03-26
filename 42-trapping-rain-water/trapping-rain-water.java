class Solution {
    public int trap(int[] height) {
        int n = height.length;
        int result = 0;
        int[] left = new int[n];
        int[] right = new int[n];

        int mx = 0;
        for(int i=0; i<n; i++) {
            mx = Math.max(mx,height[i]);
            left[i] = mx;
        }

        mx = 0;
        for(int i=n-1; i>=0; i--) {
            mx = Math.max(mx,height[i]);
            right[i] = mx;
        }
        for(int i=0; i<n; i++) {
            result += Math.min(left[i],right[i]) - height[i];
        }
        return result;
    }
}