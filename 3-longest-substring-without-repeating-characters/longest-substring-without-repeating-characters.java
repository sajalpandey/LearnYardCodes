class Solution {
    public int lengthOfLongestSubstring(String s) {
        // First solution is to check for every window that would be (n^3)

        //Optimized would be o(n)
        if(s.length() == 0)
            return 0;
        int i=0, j=0;
        HashSet<Character> set = new HashSet<>();
        int maxLen = 0;
        while(j < s.length()) {
            if(!set.contains(s.charAt(j))) {
                set.add(s.charAt(j));
                maxLen = Math.max(maxLen, (j-i));
                j++;
            } else {
                while(i < j && set.contains(s.charAt(j))) {
                    set.remove(s.charAt(i));
                    i++;
                }
            }
        }

        return (maxLen+1);
    }
}