class Solution {
      public static boolean isPalindrome(String str) {
        str = str.toLowerCase();
        int start = 0;
        int end = str.length() - 1;
        while (start < end) {
            if (str.charAt(start) != str.charAt(end)) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
    public String firstPalindrome(String[] words) {
        for(int i=0; i<words.length; i++) {
            StringBuilder str = new StringBuilder(words[i]).reverse();
            if(words[i].equals(str.toString())) {
                return words[i];
            }
        }
        return "";
    }
}