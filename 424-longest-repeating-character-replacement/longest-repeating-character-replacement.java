class Solution {
    public int characterReplacement(String s, int k) {
        int[] map = new int[26];
        int i = 0, j = 0, maxLen = 0, maxFreq = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            map[ch - 'A']++;
            maxFreq = Math.max(maxFreq, map[ch - 'A']);
            /**
            Changes = window length - maxFreq of char till now
            whene ever changes > k, will shrink our window
             */
            if((j-i+1) - maxFreq > k) {
                map[s.charAt(i) - 'A']--;
                i++;
            }
            j++;
            maxLen = Math.max(maxLen , (j-i));
        }
        return maxLen;
    }
}