class Solution {
    public List<Integer> majorityElement(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int ele : nums) {
            map.put(ele ,map.getOrDefault(ele, 0)+1);
        }

        List<Integer> result = new ArrayList<>();
        for(int key : map.keySet()) {
            if(map.get(key) > (n/3))
                result.add(key);
        }
        return result;
    }
}