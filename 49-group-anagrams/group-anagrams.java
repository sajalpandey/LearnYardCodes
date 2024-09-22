class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> map = new HashMap<>();
        for(String str : strs) {
            char [] arr = str.toCharArray();
            Arrays.sort(arr);
            String sorted = new String(arr);
            //System.out.println(str+" -- "+sorted);
            if(!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }

        List<List<String>> result = new ArrayList<>();
        for (List<String> list: map.values()) {
            result.add(list);
        }
        return result;
    }
}