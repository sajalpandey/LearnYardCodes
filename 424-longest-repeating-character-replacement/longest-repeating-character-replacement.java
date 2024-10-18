class Solution {
    public int characterReplacement(String s, int k) {
        // changes = window_length - max freq character
        // if these changes > k
        // we need to shrink our window
        
        int maxFreq = 0;
        int i = 0, j = 0;
        int[] freq = new int[26];
        
        int result = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            maxFreq = Math.max(maxFreq, ++freq[ch - 'A']);
            
            int changes = (j - i + 1) - maxFreq;
            
            if(changes > k) {
                // we need to shrink our window
                freq[s.charAt(i) - 'A']--;
                i++;
            }
            
            result = Math.max(result, (j-i+1));
            j++;
        }
        
        return result;
    }
}