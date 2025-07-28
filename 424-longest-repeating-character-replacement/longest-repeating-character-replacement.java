class Solution {
    public int characterReplacement(String s, int k) {
        // Longest substring with k distinct character
        int map[] = new int[26];
        int i = 0, j = 0, maxCount = 0, ans = 0;
        while(j < s.length()) {
            char ch = s.charAt(j);
            map[ch - 'A']++;
            maxCount = Math.max(maxCount, map[ch - 'A']);

            int windowSize = j - i + 1;
            int changes = windowSize - maxCount;
            if(changes > k) {
                map[s.charAt(i) - 'A']--;
                i++;
            }
            ans = Math.max(ans , j - i + 1);
            j++;
        }
        return ans;

    }
}