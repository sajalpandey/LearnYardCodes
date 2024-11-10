class Solution {
    public void combinationSum3Helper(int[] nums, int i, List<Integer> temp, 
    List<List<Integer>> result, int target, int k) {
        if(target == 0) {
            if(temp.size() == k)
                result.add(new ArrayList<>(temp));
            return;
        }
        if(i >= nums.length || target < 0) {
            return;
        }
        temp.add(nums[i]);
        combinationSum3Helper(nums, i+1, temp, result, target-nums[i], k);
        temp.remove(temp.size()-1);
        combinationSum3Helper(nums, i+1, temp, result, target, k);
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        int[] nums = {1,2,3,4,5,6,7,8,9};
        List<List<Integer>> result = new ArrayList<>();
        combinationSum3Helper(nums, 0, new ArrayList<>(), result, n, k);
        return result;
    }
}