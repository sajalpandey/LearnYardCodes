class Solution {
    private static boolean isVowel(char lowerCaseChar) {
        // Check if the character is a vowel
        return lowerCaseChar == 'a' || lowerCaseChar == 'e' || lowerCaseChar == 'i' || lowerCaseChar == 'o' || lowerCaseChar == 'u';
    }
    public int maxVowels(String s, int k) {
        int mx_v = 0;
        int v = 0;
        for(int i=0; i<k; i++) 
            if(isVowel(s.charAt(i)))
                v++;
        int i=0, j=k;
        mx_v = v;
        while(j<s.length()) {
            if(isVowel(s.charAt(i++)))
                v--;
            if(isVowel(s.charAt(j++)))
                v++;
            mx_v = Math.max(mx_v,v);
        }
        return mx_v;
    }
}