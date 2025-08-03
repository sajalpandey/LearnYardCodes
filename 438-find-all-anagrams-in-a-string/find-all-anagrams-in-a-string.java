class Solution {
    public boolean checkAllZero(int [] freq) {
        for(int i=0; i<freq.length; i++) {
            if(freq[i] != 0)
                return false;
        }
        return true;
    }
    public List<Integer> findAnagrams(String s2, String s1) {
        List<Integer> result = new ArrayList<>();
        if(s1.length() > s2.length())
            return result;
        
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
            result.add(i);
        }
        while(j < s2.length()) {
            freq[s2.charAt(j) - 'a']--;
            freq[s2.charAt(i++) - 'a']++;
            if(checkAllZero(freq)) {
                result.add(i);
            }
            j++;
        }
        return result;
    }
}