class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
    public void permuteHelper(int[] nums, int index, List<List<Integer>> result) {
        if(index == nums.length) {
            List<Integer> tempList = new ArrayList<>();
            for (int num : nums) {
                tempList.add(num);
            }
            result.add(tempList);
            return;
        }
        //now start to swap 
        for(int i=index; i<nums.length; i++) {
            swap(nums, index, i);
            permuteHelper(nums, index+1, result);
            swap(nums, index, i);
        }
        return;
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;
    }
}