class Solution {
    public String minWindow(String a, String b) {
        HashMap<Character, Integer> map = new HashMap<>();
        int s = 0, e = -1, count = b.length();
        int i=0, minLen = Integer.MAX_VALUE;
        for(char ch : b.toCharArray()) {
            map.put(ch, map.getOrDefault(ch, 0) + 1);
        }
        for(int j=0; j<a.length(); j++) {
            char ch = a.charAt(j);
            if(map.containsKey(ch)) {
                map.put(ch, map.get(ch)-1);
                if (map.get(ch) >= 0) {
                    count--;
                }
            }
            //we have found all character
            while(count == 0) {
                if(minLen > (j-i+1)) {
                    minLen = j-i+1;
                    s=i;
                    e=j;
                }
                char c = a.charAt(i);
                if(map.containsKey(c)) {
                    map.put(c, map.get(c) + 1);
                    if(map.get(c) > 0)
                        count++;
                }
                i++;
            }
        }
        return a.substring(s, e+1);
    }
}