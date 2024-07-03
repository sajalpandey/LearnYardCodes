class Solution {
    public String shortestPalindrome(String str) {
        StringBuilder temp = new StringBuilder();
        int pp = 31, mod = 1000000007;
        long prefixHash = 0, suffixHash = 0, p = 1;
        int index = -1;
        //we have to find longest prefix which is palinrome from 0th index
        // as char after this prefix will be required to add in front of str
        // to make it palindrome

        for(int i=0; i<str.length(); i++) {
            int newCharInt = str.charAt(i) - 'a' + 1;
            prefixHash = ((prefixHash * pp)%mod + newCharInt)%mod;

            suffixHash = (suffixHash + (newCharInt * p)%mod)%mod;

            //if both hash are equal means , both strings are palindrome
            if(prefixHash == suffixHash) {
                index = i;
                //System.out.println("index = "+index);
            }
            p = (p * 31)%mod;
        }
        //System.out.println("index = "+index);
        return new StringBuilder(str.substring(index+1, str.length())).reverse().append(str).toString();
    }
}