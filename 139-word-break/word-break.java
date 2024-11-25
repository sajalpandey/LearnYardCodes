class Solution {
    public boolean wordBreakHelper(String s, HashSet<String> set, int index) {
        if(index >= s.length()) {
            // we have reached the end all words are met return true
            return true;
        }
        if(set.contains(s))
            return true;
        
        //now iterate over every index and break
        for(int i=index; i<=s.length(); i++) {
            String temp = s.substring(index, i);
            //System.out.println(temp);
            if(set.contains(temp)) {
                if(wordBreakHelper(s, set, i))
                    return true;
            }
        }
        return false;
    }
    public int wordBreakTopDown(String s, HashSet<String> set, int index, int[] dp) {
        if(index >= s.length()) {
            // we have reached the end all words are met return true
            return 1;
        }
        if(set.contains(s))
            return 1;
        if(dp[index] != -1)
            return dp[index];

        //now iterate over every index and break
        for(int i=index; i<=s.length(); i++) {
            String temp = s.substring(index, i);
            //System.out.println(temp);
            if(set.contains(temp)) {
                if(wordBreakTopDown(s, set, i, dp) == 1)
                    return 1;
            }
        }
        return dp[index] = 0;
    }
    public boolean wordBreak(String s, List<String> wordDict) {
        //First insert all words in set to lookup in O(1)

        HashSet<String> set = new HashSet<>();
        for(String str : wordDict)
            set.add(str);
        
        //we will try to break string at every index
        // return wordBreakHelper(s, set, 0);

        int[] dp = new int[s.length() + 1];
        Arrays.fill(dp, -1);

        return (wordBreakTopDown(s, set, 0, dp) == 1 ? true : false);
    }
}