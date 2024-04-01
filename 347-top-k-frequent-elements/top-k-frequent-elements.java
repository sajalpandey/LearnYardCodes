class Solution {
    class Comp implements Comparator<Map.Entry<Integer, Integer>>{
        public int compare(Map.Entry<Integer, Integer> entry1, Map.Entry<Integer, Integer> entry2) {
            return entry2.getValue().compareTo(entry1.getValue());
        }
    }
    public int[] topKFrequent(int[] nums, int k) {
        int result[] = new int[k];
        HashMap<Integer,Integer> map = new HashMap<>();
        for (int ele : nums)
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        List<Map.Entry<Integer, Integer>> entryList = new ArrayList<>(map.entrySet());
        Collections.sort(entryList, new Comp());
        //System.out.println(entryList);
        for(int i=0; i<entryList.size() && i<k; ++i) {
            result[i] = entryList.get(i).getKey();
        }
        return result;
    }
}