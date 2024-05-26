class Solution {
    private int countSubsequence(int[] arr, int n) {
        if (n == 0) return 0;
        int incl = arr[0];
        int excl = 0;
        int excl_new;
        int i;
 
        for (i = 1; i < n; i++) {
            // Current max excluding i
            excl_new = Math.max(incl, excl);
 
            // Current max including i
            incl = excl + arr[i];
            excl = excl_new;
        }
 
        // Return max of incl and excl
        return Math.max(incl, excl);
    }
    public int maximumSumSubsequence(int[] nums, int[][] queries) {
        int ans = 0;
        int mod = 1_000_000_007;
        int n = nums.length;
        
        for (int[] query : queries) {
            int index = query[0];
            int newValue = query[1];
            int oldValue = nums[index];
            nums[index] = newValue;
            ans = (ans + countSubsequence(nums, n)) % mod;
            //nums[index] = oldValue;  // restore the old value for the next query
        }
        
        return ans;
    }
}