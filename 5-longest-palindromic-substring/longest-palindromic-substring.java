class Solution {
    public int isPalindrome(String s, int i, int j, int[][] dp) {
        if(i >= j)
            return 1;
        
        if(dp[i][j] != -1)
            return dp[i][j];
        
        if(s.charAt(i) == s.charAt(j))
            return dp[i][j] = isPalindrome(s, i+1, j-1, dp);
        
        return dp[i][j] = 0;
    }
    public String longestPalindrome(String s) {
        //1. Brute force O(n^3)
        //2. Expand around corner TC:O(n^2), SC: O(1)

        //3. Recursion + Memoization TC:O(n^2), SC: O(n^2)
        int n = s.length();
        int[][] dp = new int[n+1][n+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        String result = "";
        for(int i=0; i<n; i++) {
            for(int j=i; j<n; j++) {
                if(isPalindrome(s, i, j, dp) == 1) {
                    if(result.length() < (j-i+1)) {
                        result = s.substring(i, j+1);
                    }
                }
            }
        }
        return result;
    }
}