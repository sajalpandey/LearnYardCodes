class Solution {
    public int lengthOfLongestSubstring(String s) {
        int i = 0, j = 0;
        int count = 0, result = 0;
        HashMap<Character, Integer> map = new HashMap<>();
        while(j < s.length()) {
            char ch = s.charAt(j);
            if(!map.containsKey(ch)) {
                map.put(ch, 1);
            } else {
                while(map.containsKey(ch) && i < j) {
                    map.remove(s.charAt(i++));
                }
                map.put(ch, 1);
            }
            j++;
            result = Math.max(result, (j-i));
        }
        return result;
    }
}