class Solution {
    public void subsetsWithDupHelper(List<List<Integer>> result, int[] nums, int index, List<Integer> temp) {
        // we will simply add , as [] is also part of result
        result.add(new ArrayList<>(temp));

        //now loop from index to < n and pick every ele
        //after picking if next ele is equal to previous picked we will move fw
        for(int i=index; i<nums.length; i++) {
            //
            if(i > index && nums[i] == nums[i-1])
                continue;
            temp.add(nums[i]);
            subsetsWithDupHelper(result, nums, i+1, temp);
            temp.remove(temp.size()-1); 
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        subsetsWithDupHelper(result, nums, 0, new ArrayList<>());
        return result;
    }
}