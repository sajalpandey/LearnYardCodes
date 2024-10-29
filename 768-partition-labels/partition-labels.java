class Solution {
    public List<Integer> partitionLabels(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(int i=0; i<s.length(); i++) {
            map.put(s.charAt(i), i);
        }
        List<Integer> result = new ArrayList<>();
        int last_index = map.get(s.charAt(0));
        int prev = 0;
        for(int i=0; i<s.length(); i++) {
            last_index = Math.max(last_index, map.get(s.charAt(i)));
            if(i == last_index) {
                // we have found the partition
                result.add((i+1 - prev));
                prev = last_index+1;
            }
            
        }
        return result;
    }
}