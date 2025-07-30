class Solution {
    public int numberOfSubstrings(String s) {
        int result = 0;
        int n = s.length(), i = 0;
        int [] freq = new int[3];
        for(int j=0; j<n; j++) {
            freq[s.charAt(j) - 'a']++;
            while(i < n && freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                //found all characters
                result += n - j;
                freq[s.charAt(i) - 'a']--;
                i++;
            }
        }
        return result;
    }
}