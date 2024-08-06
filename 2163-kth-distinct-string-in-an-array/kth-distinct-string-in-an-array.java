class Solution {
    public String kthDistinct(String[] arr, int k) {
        HashMap<String, Integer> map = new HashMap<>();
        ArrayList<String> list = new ArrayList<>();
        for(String str : arr) {
            if(!map.containsKey(str)) {
                map.put(str, 1);
                list.add(str);
            }
            else
            {
                list.remove(str);
            }
        }

        if(k > list.size())
            return "";
        return list.get(k-1);
    }
}