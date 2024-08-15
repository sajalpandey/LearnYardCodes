class Solution {
    public int atMostKDifferentSubArray(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int count = 0; 
        int i = 0; 
        for(int j=0; j<nums.length; j++) {
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);
            while(map.size() > k) {
                map.put(nums[i], map.get(nums[i])-1);
                if(map.get(nums[i]) == 0)
                    map.remove(nums[i]);
                i++;
            }
            count += (j-i+1);
        }
        return count;
    }
    public int subarraysWithKDistinct(int[] nums, int k) {

        /** To Fin exact k different integer in subaaray
        find at most k different integer in subaaray
         - At most (k-1) different integer in sub-array */

        return atMostKDifferentSubArray(nums, k) - atMostKDifferentSubArray(nums, k-1);
    }
}