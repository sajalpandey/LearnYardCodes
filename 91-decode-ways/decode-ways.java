class Solution {
    public boolean isValid(String str) {
        if(str.length() == 1) {
            return (str.charAt(0) == '0' ? false : true);
        } else if(str.length() == 2) {
            if(str.charAt(0) == '0')
                return false;
            int num = Integer.parseInt(str);
            if(num >= 10 && num <= 26)
                return  true;
        }
        return false;
    }
    public int numDecodingsHelper(String s, int i, int[] dp) {
        if(i >= s.length()) {
            return 1;
        }
        if(dp[i] != -1)
            return dp[i];
        int count1 = 0;

        //either take 1 char
        String strLen1 = s.substring(i,i+1);
        boolean flag = isValid(strLen1);
        if(flag == true) {
            count1 += numDecodingsHelper(s, i+1, dp);
        }

        //eight take 2 char
        int count2 = 0;
        if((i+2) <= s.length()) {
            String strLen2 = s.substring(i,i+2);
            if(isValid(strLen2))
                count2 += numDecodingsHelper(s, i+2, dp);
        }
        dp[i] = count1+count2;
        return dp[i];    
    }
    public int numDecodings(String s) {
        int n = s.length();
        int[] dp = new int[n+2];
        dp[0] = 1;
        Arrays.fill(dp, -1);
        return numDecodingsHelper(s, 0, dp);
    }
}