class Solution {
    public static void helper(List<List<Integer>> result,List<Integer> temp,int [] nums, int i,int j) {
        if(i>=j) {
            result.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[i]);
        helper(result,temp,nums,i+1,j);
        temp.remove(temp.size()-1);
        helper(result,temp,nums,i+1,j);
    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        //result.add(temp);
        helper(result,temp,nums,0,nums.length);
        return result;
    }
}