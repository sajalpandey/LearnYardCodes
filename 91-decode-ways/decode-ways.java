class Solution {
    public boolean isValid(String str) {
        boolean result = false;
        if(str.length() == 1) {
            result = ((str.charAt(0) == '0') ? false : true);
            //System.out.println(str+" -- "+result);
        }
        if(str.charAt(0) != '0') {
            int num = Integer.parseInt(str);
            if(num >= 10 && num <= 26)
                result = true;
        }
        //System.out.println(str+" -- "+result);
        return result;
    }
    public int numDecodingsHelper(String s, int i) {
        //this means we are able to partiton, reached till end
        if(i >= s.length())
            return 1;
        
        //we have two choices either take 1 character or 2 character
        int count1 = 0;
        String str1 = s.substring(i, i+1);
        if(isValid(str1))
            count1 += numDecodingsHelper(s, i+1);
        
        int count2 = 0;
        if(i+2 <= s.length()) {
            String str2 = s.substring(i, i+2);
            if(isValid(str2))
                count2 += numDecodingsHelper(s, i+2);
        }

        return count1+count2;
    }
    public int numDecodingsMemo(String s, int i, int[] dp) {
        //this means we are able to partiton, reached till end
        if(i >= s.length())
            return 1;
        if(dp[i] != -1)
            return dp[i];
        
        //we have two choices either take 1 character or 2 character
        int count1 = 0;
        String str1 = s.substring(i, i+1);
        if(isValid(str1))
            count1 += numDecodingsMemo(s, i+1, dp);
        
        int count2 = 0;
        if(i+2 <= s.length()) {
            String str2 = s.substring(i, i+2);
            if(isValid(str2))
                count2 += numDecodingsMemo(s, i+2, dp);
        }

        return dp[i] = count1+count2;
    }
    public int numDecodings(String s) {
        //1. Recursive approach
        int n = s.length();
        //return numDecodingsHelper(s, 0);

        //2. Top Down
        int[] dp = new int[n+1];
        Arrays.fill(dp, -1);
        return numDecodingsMemo(s, 0 , dp);
    }
}