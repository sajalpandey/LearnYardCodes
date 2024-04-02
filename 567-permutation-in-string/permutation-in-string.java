class Solution {
    private boolean allZeros(int[] count) {
        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        int l1 = s1.length(), l2 = s2.length();
        if(l1 > l2)
            return false;
        int [] freq = new int [26];
        for(int i=0; i<l1; i++)
            freq[s1.charAt(i) - 'a']++;
        
        for(int i=0; i<l2; ++i) {
            if(i >= l1)
                freq[s2.charAt(i-l1) - 'a']++;
            freq[s2.charAt(i) - 'a']--;
            if(allZeros(freq))
                return true;
        }
        return false;
    }
}