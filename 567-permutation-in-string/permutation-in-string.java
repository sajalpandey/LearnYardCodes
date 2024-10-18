class Solution {

    public boolean checkAllZero(int[] freq){
        for(int i=0; i<freq.length; i++) {
            if(freq[i] != 0)
                return false;
        }
        return true;
    }
    public boolean checkInclusion(String s1, String s2) {
        //Permutaion means all characters of s1 should be present in s2
        //store all characters in freq array
        //for each window of size(s1) in s2 find if it contains all chars of s1

        //TC : O(|s2|)

        int[] freq = new int[26];
        for(char ch : s1.toCharArray()) {
            freq[ch - 'a']++;
        }

        for(int i=0; i<s2.length(); i++) {
            char ch = s2.charAt(i);
            freq[ch - 'a']--;

            if(i >= s1.length()) {
                freq[s2.charAt(i-s1.length()) - 'a']++;
            }
            if(checkAllZero(freq))
                    return true;
        }


        return false;

    }
}