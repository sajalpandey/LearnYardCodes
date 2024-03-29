class Solution {
    public int numIdenticalPairs(int[] nums) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int ans = 0;
        for(int i=0; i<nums.length; ++i) {
            if(map.containsKey(nums[i])) 
                ans += map.get(nums[i]);
            map.put(nums[i],map.getOrDefault(nums[i],0)+1);
        }
        return ans;
    }
}