class Solution {
    public boolean checkAllZero(int [] freq) {
        for(int i=0; i<freq.length; i++) {
            if(freq[i] != 0)
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length() > s2.length())
            return false;
        int[] freq = new int[26];
        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }
        int i = 0, j = 0;
        while(j < s1.length()) {
            freq[s2.charAt(j) - 'a']--;
            j++;
        }

        if(checkAllZero(freq)) {
            return true;
        }
        while(j < s2.length()) {
            freq[s2.charAt(j) - 'a']--;
            freq[s2.charAt(i++) - 'a']++;
            if(checkAllZero(freq)) {
                return true;
            }
            j++;
        }
        return false;
    }
}