class Solution {
    public boolean isMatchHelper(String s, String p, int i, int j) {
        //base case
        if(i < 0 && j < 0)
            return true;
        if(j < 0)
            return false;
        if(i < 0) {
            for(int k=0; k<=j; k++)
                if(p.charAt(k) != '*')
                    return false;
            return true;
        }

        if(s.charAt(i) == p.charAt(j) || p.charAt(j) == '.')
            return isMatchHelper(s, p, i-1, j-1);
        else if(p.charAt(j) == '*') //either to take * as empty or match char at i
            return (isMatchHelper(s, p, i-1, j) || isMatchHelper(s, p, i, j-1));
        else
            return false;
    }

    public boolean isMatchTopDown(String s, String p, int i, int j, int[][] dp) {
        //base case
        if(i == 0 && j == 0)
            return true;
        if(j == 0)
            return false;
        if(i == 0) {
            for(int k=1; k<=j; k++)
                if(p.charAt(k-1) != '*')
                    return false;
            return true;
        }
        if(dp[i][j] != -1)
            return dp[i][j] == 1;

        boolean ans = false;
        if(s.charAt(i-1) == p.charAt(j-1) || p.charAt(j-1) == '?')
            ans = isMatchTopDown(s, p, i-1, j-1, dp);
        else if(p.charAt(j-1) == '*') //either to take * as empty or match char at i
            ans = (isMatchTopDown(s, p, i-1, j, dp) || isMatchTopDown(s, p, i, j-1, dp));
        else
            ans = false;
        dp[i][j] = (ans == true ? 1 : 0);
        return ans;
    }

    public boolean isMatch(String s, String p) {
        //1. Recursion
        //return isMatchHelper(s, p, s.length()-1, p.length()-1);

        //2.DP Top Down
        int[][] dp = new int[s.length()+1][p.length()+1];
        for(int[] row : dp)
            Arrays.fill(row, -1);
        return isMatchTopDown(s, p, s.length(), p.length(), dp);

        //3. DP Bottom Up 
        //First we need to convert our top down solution to 1 bases indexing, then
        //it will be easier to solve bottom up
    }
}