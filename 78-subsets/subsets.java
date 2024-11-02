class Solution {
    public void subsetsHelper(int i, int n, List<Integer> temp, 
    List<List<Integer>> result, int[] nums) {
        if(i >= n) {
            result.add(new ArrayList<>(temp));
            return;
        }
        //we have 2 choices take it or not
        temp.add(nums[i]);
        subsetsHelper(i+1, n, temp, result, nums);
        temp.remove(temp.size()-1);
        subsetsHelper(i+1, n, temp, result, nums);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;

        subsetsHelper(0, n, temp, result, nums);
        return result;
    }
}