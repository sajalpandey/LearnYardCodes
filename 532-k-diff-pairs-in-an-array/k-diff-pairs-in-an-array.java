class Solution {
    public int findPairs(int[] nums, int k) {
//         For k > 0:
// Use a Set to store all unique numbers.
// For each num, check if num + k exists in the set.
// For k == 0:
// Count numbers that appear at least twice.

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int ele : nums) {
            map.put(ele, map.getOrDefault(ele, 0) + 1);
        }
        int count = 0;
        for(int key : map.keySet()) {
            if(k == 0) {
                if(map.get(key) >= 2)
                    count++;
            } else {
                if(map.containsKey(key + k))
                    count++;
            }
        }
        return count;
    }
}