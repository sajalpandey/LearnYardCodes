class Solution {
    public int maxArea(int[] arr) {
        // One solution is to check for each pair Yn : O(n^2)
        int i = 0, j = arr.length - 1;
        int ans = Integer.MIN_VALUE;
        while(i < j) {
            int area = (j - i) * Math.min(arr[i], arr[j]);
            ans = Math.max(ans, area);
            if(arr[i] < arr[j])
                i++;
            else
                j--;
        }
        return ans;

    }
}