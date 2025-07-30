class Solution {
    public int equalSubstring(String s, String t, int maxCost) {
        int cost = 0, i = 0, j = 0;
        int maxLen = 0;
        while(j < s.length()) {
            cost += Math.abs(s.charAt(j) - t.charAt(j));
            j++;
            while(i < s.length() && cost > maxCost) {
                //shrink window
                cost -= Math.abs(s.charAt(i) - t.charAt(i));
                i++;
            }
            maxLen = Math.max(maxLen, (j - i));
        }
        return maxLen;
    }
}