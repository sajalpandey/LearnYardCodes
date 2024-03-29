class Solution {
    public int lengthOfLongestSubstring(String s) {
        HashMap<Character,Integer> map = new HashMap<>();
        int length = 0, i = 0, j = 0;
        while(j < s.length()) {
            char c = s.charAt(j);
            map.put(c, map.getOrDefault(c,0)+1);
            while(i < j && map.get(c) > 1) {
                int freq = map.get(s.charAt(i));
                map.put(s.charAt(i), freq - 1);
                i++;
            }
            j++;
            length = Math.max(length, (j-i));
        }
        //length = Math.max(length, (j-i+1));
        return length;
    }
}