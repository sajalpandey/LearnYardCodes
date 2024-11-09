class Solution {
    HashSet<List<Integer>> set = new HashSet<>();
    public void subsetsWithDupHelper(List<List<Integer>> result, int[] nums, int i, List<Integer> temp) {
        if(i >= nums.length) {
            if(!set.contains(temp)) {
                set.add(new ArrayList<>(temp));
            }
            return;
        }
        temp.add(nums[i]);
        subsetsWithDupHelper(result, nums, i+1, temp);
        temp.remove(temp.size()-1);
        subsetsWithDupHelper(result, nums, i+1, temp);
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupHelper(result, nums, 0, new ArrayList<>());
        for(List<Integer> temp : set) {
            result.add(new ArrayList<>(temp));
        }
        return result;
    }
}