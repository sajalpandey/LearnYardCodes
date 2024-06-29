class Solution {
    public int[] prefixHelper(String s) {
        int n = s.length();
        int[] prefix = new int[n];
        int j=0, i=1;
        while(i < n) {
            if(s.charAt(i) == s.charAt(j)) {
                prefix[i] = j+1;
                i++;j++;
            } else {
                if(j > 0)
                    j = prefix[j-1];
                else
                    i++;
            }
        }
        return prefix;
    }
    public String longestPrefix(String s) {
        int[] prefix = prefixHelper(s);
        return s.substring(0, prefix[s.length()-1]);
    }
}