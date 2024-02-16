class Solution {
    public int numberOfSubstrings(String s) {
        int freq[] = new int[4];
        int result = 0;
        int j=0;
        for(int i=0; i<s.length(); i++) {
            freq[s.charAt(i)-'a']++;
            while(freq[0] > 0 && freq[1] > 0 && freq[2] > 0) {
                //System.out.println("i = "+i);
                result += s.length()-i;
                freq[s.charAt(j++)-'a']--;
            }
        }
        return result;
    }
}