class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<>();
        if(words.length == 0 || s.length() == 0)
            return result;
        int wordLen = words[0].length();
        int totalLen = wordLen * words.length;
        if (s.length() < totalLen) return result;

        //store freq of char in map
        HashMap<String, Integer> freq = new HashMap<>();
        for(int i=0; i<words.length; i++) 
            freq.put(words[i], freq.getOrDefault(words[i], 0) + 1);
        
        for(int i=0; i<=s.length() - totalLen; i++) {
            String window = s.substring(i, i+totalLen);

            HashMap<String, Integer> seen = new HashMap<>();
            for(int j=0; j<totalLen; j = j + wordLen) {
                String str = window.substring(j, j+wordLen);
                seen.put(str, seen.getOrDefault(str, 0) + 1);
            }

            if(seen.equals(freq)) {
                result.add(i);
            }
        }

        return result;
    }
}