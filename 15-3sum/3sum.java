class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        for(int i=0; i<nums.length; i++) {
            int j = i+1, k = nums.length-1;
            while(j < k) {
                if((nums[i] + nums[j] + nums[k]) == 0) {
                    result.add(Arrays.asList(nums[i], nums[j], nums[k]));
                    while((j+1) < k && nums[j] == nums[j+1])
                        j++;
                    while((k-1) > j && nums[k] == nums[k-1])
                        k--;
                    j++;
                    k--;
                } else if((nums[i] + nums[j] + nums[k]) < 0) {
                    j++;
                } else {
                    k--;
                }
               
            }
            while(i+1 < nums.length && nums[i] == nums[i+1])
                i++;
        }
        return result;
    }
}