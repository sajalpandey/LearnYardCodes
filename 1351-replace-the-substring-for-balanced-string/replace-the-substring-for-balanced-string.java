class Solution {
    public int balancedString(String s) {
        //idea here is that
        //we will have a window , which needs to be balanced and try to shrink that window
        //outside window each character should be <= target (out is balanced)

        int[] freq = new int[26];
        for(char ch: s.toCharArray()) {
            freq[ch - 'A']++;
        }
        int i = 0, result = s.length();
        int target = s.length() / 4;
        for(int j = 0; j < s.length(); j++) {
            freq[s.charAt(j) - 'A']--;
            while(i < s.length() && freq['Q'- 'A'] <= target && freq['W' - 'A'] <= target
            && freq['E' - 'A'] <= target && freq['R' - 'A'] <= target) {
                freq[s.charAt(i) - 'A']++;
                result = Math.min(result, (j - i + 1));
                i++;
            }
        }
        return result;
    }
}