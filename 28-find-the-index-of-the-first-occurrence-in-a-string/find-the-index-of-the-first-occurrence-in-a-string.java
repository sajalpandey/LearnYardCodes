class Solution {
    public int strStr(String haystack, String needle) {
        int n = needle.length();
        for(int i=0; i<haystack.length(); i++) {
            int j = i+n;
            if(j <= haystack.length() && haystack.substring(i,j).equals(needle))
                return i;
        }
        return -1;
    }
}