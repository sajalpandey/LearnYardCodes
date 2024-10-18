class Solution {
    public String minWindow(String a, String b) {
        int s = 0, e = -1;
        int j = 0, minLen = Integer.MAX_VALUE;
        
        //First store frequency of all character of p in map
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<b.length(); i++)
            map.put(b.charAt(i), map.getOrDefault(b.charAt(i), 0)+1);
        
        //Now iterate through all string s
        //when all characters are found , try to minimize the window
        int count = b.length(); // this many character need to found in s
        int k = 0;
        while(j < a.length()) {
            char ch = a.charAt(j);
            //we will decrease freq of every char
            //only chars present in b will have >= 0 freq
            map.put(ch, map.getOrDefault(ch, 0) - 1);
            
            //we found a char which is also present in "b"
            if(map.get(ch) >= 0)
                count--;
                
            //count == 0 , means we found all character in "a"
            // we need to shrink our window
            while(count == 0) {
                if(minLen > (j - k + 1)) {
                    s = k;
                    e = j;
                    minLen = (j - k + 1);
                }
                char c = a.charAt(k);
                map.put(c, map.getOrDefault(c, 0) + 1);
                
                if(map.get(c) > 0)
                    count++;
                k++;
            }
            j++;
        }
        
        return (minLen == Integer.MAX_VALUE ? "" : a.substring(s, e+1));
    }
}