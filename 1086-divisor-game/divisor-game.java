class Solution {
    public boolean divisorGameHelper(int n, int[] dp) {
        if(n == 1)
            return false;
        if(dp[n]!=-1) {
            if(dp[n] == 0)
                return false;
            return true;
        }
        for(int i=1; i<n; i++) {
            if(n%i == 0) {
                boolean flag = divisorGameHelper(n-i, dp);
                flag = flag == false ? true : false;
                dp[n] = 1;
                return flag;
            }
        }
        dp[n] = 0;
        return false;
    }
    public boolean divisorGame(int n) {
        if(n%2==0)
            return true;
        return false;
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, -1);
        // return divisorGameHelper(n, dp);
    }
}